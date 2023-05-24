package com.github.hrozhek.signistmlverificatorservice.service;


import com.github.hrozhek.signistmlverificatorservice.model.ModelEntity;

import java.awt.image.BufferedImage;

public interface VerificatorService {

    ModelEntity registerModel(long modelId, BufferedImage image);

    boolean verify(long modelId, BufferedImage image);

    void reserve(long modelId);

    void free(long modelId);
}
