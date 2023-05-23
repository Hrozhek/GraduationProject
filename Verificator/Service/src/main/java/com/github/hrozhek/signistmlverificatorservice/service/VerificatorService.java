package com.github.hrozhek.signistmlverificatorservice.service;

import com.github.hrozhek.signistservicepersondata.model.ModelEntity;

import java.awt.image.BufferedImage;

public interface VerificatorService {

    ModelEntity /*todo long*/ registerModel(long modelId, BufferedImage image);

    boolean verify(long modelId, BufferedImage image);

    void reserve(long modelId);

    void free(long modelId);
}
