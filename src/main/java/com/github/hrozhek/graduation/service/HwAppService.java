package com.github.hrozhek.graduation.service;

import com.github.hrozhek.graduation.util.Analyzer;
import com.github.hrozhek.graduation.util.Base64Converter;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class HwAppService {

    //according to https://web.archive.org/web/20160305150423/http://www.lac.inpe.br/JIPCookbook/6050-howto-compareimages.jsp
    private static final long DEFAULT_ZERO_THRESHOLD = 4500;

    private static final Object SYNC_ROOT = new Object();

    private final Analyzer analyzer = new Analyzer();
    private final AtomicLong currentZeroThreshold = new AtomicLong(DEFAULT_ZERO_THRESHOLD);

    private int outlierCounter = 0;
    private int normalCounter = 0;

    public double compare(String refSignature, String presentedSignature) {
        var ref = Base64Converter.convertImage(refSignature);
        var presented = Base64Converter.convertImage(presentedSignature);
        return mockCompare(ref, presented);
    }

    private double mockCompare(BufferedImage ref, BufferedImage presented) {
        var distance = analyzer.compare(ref, presented); //closer to 0 is closer to 100%
        double max = Math.max(currentZeroThreshold.updateAndGet(val -> updateFunction(val, distance)),
                distance); //avoid negative numbers
        return ((max - distance) / max) * 100.0;
    }

    private long updateFunction(long ref, double distance) {
        var thresholdedDistance = (long) distance * 1.3;
        long outlier, normal;
        synchronized (SYNC_ROOT) {
            if (ref < thresholdedDistance) {
                outlierCounter++;
            } else {
                normalCounter++;
            }
            outlier = outlierCounter;
            normal = normalCounter;
        }
        if (outlier < 50) {
            return ref;
        }
        if (outlier * 3 > normal) {
            //on ~33% threshold of outliers, let's update zero threshold
            synchronized (SYNC_ROOT) {
                outlierCounter = 0;
                normalCounter = 0;
            }
            return (long) distance;
        }
        return ref;
    }
}
