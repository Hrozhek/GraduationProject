package com.github.hrozhek.signistserviceperson.service;

import com.github.hrozhek.signistserviceperson.model.ModelEntity;

public interface ModelService {

    ModelEntity getPersonModel(long personId);

    ModelEntity addModel(long personId);

    ModelEntity deleteModel(long personId);
}
