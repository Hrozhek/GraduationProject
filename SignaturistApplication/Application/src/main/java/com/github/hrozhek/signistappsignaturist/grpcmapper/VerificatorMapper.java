package com.github.hrozhek.signistappsignaturist.grpcmapper;

import com.github.hrozhek.signist.ml.spoofer.Spoofer;
import com.github.hrozhek.signist.ml.verificator.Verificator;
import com.github.hrozhek.signistappsignaturist.dto.ImageRequest;

import static com.github.hrozhek.signistappsignaturist.util.ByteUtils.convertImage;

public class VerificatorMapper {

    public static Verificator.Image mapRequest(ImageRequest request) {
        return Verificator.Image.newBuilder()
                .setData(convertImage(request.getBase64Image()))
                .build();
    }

    public static Verificator.ModelData mapModelData(long modelId) {
        return Verificator.ModelData.newBuilder().setModelId(modelId).build();
    }
}
