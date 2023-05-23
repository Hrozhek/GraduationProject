package com.github.hrozhek.signistappsignaturist.grpcmapper;

import com.github.hrozhek.signist.ml.detector.Detector;
import com.github.hrozhek.signistappsignaturist.dto.ImageRequest;

import static com.github.hrozhek.signistappsignaturist.util.ByteUtils.convertImage;

public class DetectorMapper {

    private DetectorMapper() {

    }

    public static Detector.Image mapRequest(ImageRequest request) {
        return Detector.Image.newBuilder()
                .setData(convertImage(request.getBase64Image()))
                .build();
    }
}
