package com.github.hrozhek.signistmlverificatorservice.service;

import com.github.hrozhek.signistmlverificatorservice.mock.DecisionMaker;
import com.github.hrozhek.signistmlverificatorservice.model.ModelEntity;
import com.github.hrozhek.signistmlverificatorservice.repo.ModelRepo;
import com.github.hrozhek.signistmlverificatorservice.storage.ModelStorage;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VerificatorServiceImpl implements VerificatorService {

    private final ModelRepo repo;

    private final ModelStorage storage;

    private final DecisionMaker decisionMaker;

    @Override
    public ModelEntity registerModel(long modelId, BufferedImage image) {
        ModelEntity model = repo.findById(modelId).orElseThrow(IllegalArgumentException::new); //todo
        if (StringUtils.isNotBlank(model.getModelRef())) {
            throw new RuntimeException(String.format("model %d already exists", modelId)); //todo
        }
        String path = storage.save(image);
        model.setModelRef(path);
        return repo.save(model); //todo is it ok?
    }

    @Override
    public boolean verify(long modelId, BufferedImage image) {
        ModelEntity model = repo.findById(modelId).orElseThrow(IllegalArgumentException::new);
        String path = model.getModelRef();
        if (StringUtils.isBlank(path)) {
            throw new RuntimeException(String.format("model %d not registered", modelId)); //todo
        }
        BufferedImage ref = storage.load(path);
        double similarity = decisionMaker.makeDecision(ref, image);
        return similarity >= DecisionMaker.SIMILARITY_THRESHOLD;
    }

    @Override
    public void reserve(long modelId) {
        //todo
    }

    @Override
    public void free(long modelId) {
        //todo
    }
}
