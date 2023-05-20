package com.github.hrozhek.signistserviceperson.service;

public interface ModelService {

    Object getPersonModel(long personId);

    Object addModel(long personId);

    Object deleteModel(long personId);
}
