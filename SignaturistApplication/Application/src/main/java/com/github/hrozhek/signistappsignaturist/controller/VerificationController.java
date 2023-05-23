package com.github.hrozhek.signistappsignaturist.controller;

import com.github.hrozhek.signistappsignaturist.dto.VerificationRequest;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface VerificationController {

//    List<Object> getHistory(long personId); //todo e.g. userId timestamp result - success/failure (in case of exceptions) and score if succeeded etc.

    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "400", description = "empty data in request")
    ResponseEntity<Boolean> verify(VerificationRequest signature); // todo - должен остаться в истории и быть доступен результат сравнения

    //todo нужно ли хранить переданные образцы? Как будет происходить enrich модели
}
