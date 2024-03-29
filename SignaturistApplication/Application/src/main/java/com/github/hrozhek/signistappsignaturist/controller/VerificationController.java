package com.github.hrozhek.signistappsignaturist.controller;

import com.github.hrozhek.signistappsignaturist.dto.VerificationRequest;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface VerificationController {

//    List<Object> getHistory(long personId); //todo e.g. userId timestamp result - success/failure (in case of exceptions) and score if succeeded etc.

    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "400", description = "hmm")//todo
    ResponseEntity<Boolean> verify(@RequestBody VerificationRequest signature); // todo - должен остаться в истории и быть доступен результат сравнения

    //todo нужно ли хранить переданные образцы? Как будет происходить enrich модели
}
