package com.github.hrozhek.signistserviceperson.controller;

import java.util.List;

public interface ModelController {

    Object /*List<Object>*/ getPersonModel/*s*/();

    Object addModel(long personId);

    Object deleteModel(/*personId or modelId*/);

    //todo there can be methods for files for models
}
