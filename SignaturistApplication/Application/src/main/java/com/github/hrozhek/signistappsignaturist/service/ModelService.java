package com.github.hrozhek.signistappsignaturist.service;

import com.github.hrozhek.signistappsignaturist.dto.ModelResponse;
import com.github.hrozhek.signistappsignaturist.dto.RegisterModelRequest;


public interface ModelService {

    ModelResponse getModel(long personId);

    ModelResponse addModel(long personId);

    void deleteModel(long id);

    long register(RegisterModelRequest request);
}
