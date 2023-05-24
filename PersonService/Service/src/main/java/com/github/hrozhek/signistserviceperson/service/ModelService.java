package com.github.hrozhek.signistserviceperson.service;

import com.github.hrozhek.signistservicepersondata.model.ModelEntity;

public interface ModelService {

    ModelEntity getPersonModel(long personId);

    ModelEntity addModel(long personId);

    void deleteModel(long modelId);
}
