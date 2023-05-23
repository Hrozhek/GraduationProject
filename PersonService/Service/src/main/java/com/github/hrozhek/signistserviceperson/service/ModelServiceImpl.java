package com.github.hrozhek.signistserviceperson.service;

import com.github.hrozhek.signistserviceperson.model.ModelEntity;
import com.github.hrozhek.signistserviceperson.repo.ModelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepo repo;

    @Override
    public ModelEntity getPersonModel(long personId) {
        return repo.findByPersonId(personId);
    }

    @Override
    public ModelEntity addModel(long personId) {
        return null;
    }

    @Override
    public ModelEntity deleteModel(long modelId) {
        return null;
    }
}
