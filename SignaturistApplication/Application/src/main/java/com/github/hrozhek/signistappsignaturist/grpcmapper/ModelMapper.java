package com.github.hrozhek.signistappsignaturist.grpcmapper;

import com.github.hrozhek.signist.service.person.Models;
import com.github.hrozhek.signistappsignaturist.dto.ModelResponse;

import java.util.Optional;

public class ModelMapper {

    private ModelMapper() {
    }

    public static ModelResponse mapModel(Models.Model model) {
        ModelResponse response = new ModelResponse();
        response.setId(model.getModelId().getModelId());
        response.setPersonId(model.getPersonId());
        if (model.hasModelData()) {
            response.setModelRef(Optional.of(model.getModelData()));
        } else {
            response.setModelRef(Optional.empty());
        }
        return response;
    }
}
