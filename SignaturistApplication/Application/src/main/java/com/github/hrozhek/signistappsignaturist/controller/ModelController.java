package com.github.hrozhek.signistappsignaturist.controller;

import com.github.hrozhek.signistappsignaturist.dto.ModelResponse;
import com.github.hrozhek.signistappsignaturist.dto.RegisterModelRequest;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

//todo id сессии, и из нее берем
public interface ModelController {

//    @ApiResponse(responseCode = "200", description = "ok")
//    @ApiResponse(responseCode = "400", description = "hmm")//todo
    ResponseEntity<ModelResponse> getModel(long personId); //todo check PersonService

//    @ApiResponse(responseCode = "200", description = "ok")
//    @ApiResponse(responseCode = "400", description = "hmm")//todo
    ResponseEntity<ModelResponse> addModel(long personId); //todo personId matters

//    /*void*/ Object enrichModel(long personId, Object image); //todo only personId matters

//    @ApiResponse(responseCode = "200", description = "ok")
//    @ApiResponse(responseCode = "400", description = "hmm")//todo
    ResponseEntity deleteModel(long id);

//    @ApiResponse(responseCode = "200", description = "ok")
//    @ApiResponse(responseCode = "400", description = "hmm")//todo
    ResponseEntity<Long> registerModel(RegisterModelRequest request);
}
