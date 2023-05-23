package com.github.hrozhek.signistappsignaturist.grpcmapper;

import com.github.hrozhek.signist.ml.spoofer.Spoofer;
import com.github.hrozhek.signistappsignaturist.dto.ImageRequest;

import static com.github.hrozhek.signistappsignaturist.util.ByteUtils.convertImage;

public class SpooferRequestMapper {

    private SpooferRequestMapper() {
    }

    public static Spoofer.Image mapRequest(ImageRequest request) {
        return Spoofer.Image.newBuilder()
                .setData(convertImage(request.getBase64Image()))
                .build();
    }
}
