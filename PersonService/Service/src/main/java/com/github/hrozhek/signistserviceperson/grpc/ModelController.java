package com.github.hrozhek.signistserviceperson.grpc;

public interface ModelController {

    Object getPersonModel(long personId);

    Object addOrUpdateModel(long personId);

    Object deleteModel(long modelId);

    void checkModel(long modelId);

    //todo there can be methods for files for models
}
