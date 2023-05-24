package com.github.hrozhek.signistappsignaturist.controller;

import com.github.hrozhek.signistappsignaturist.dto.AddPersonRequest;
import com.github.hrozhek.signistappsignaturist.dto.PersonResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonController {

//    @ApiResponse(responseCode = "200", description = "ok")
//    @ApiResponse(responseCode = "400", description = "hmm")//todo
    ResponseEntity<List<PersonResponse>> getAll(); //todo paginated

//    @ApiResponse(responseCode = "200", description = "ok")
//    @ApiResponse(responseCode = "400", description = "hmm")//todo
    ResponseEntity<PersonResponse> getPerson(long personId);

//    @ApiResponse(responseCode = "200", description = "ok")
//    @ApiResponse(responseCode = "400", description = "hmm")//todo
    ResponseEntity<PersonResponse> addPerson(AddPersonRequest person); //todo personId matters

//    /*void*/ Object updatePerson(long id, Object person); //todo only personId matters

//    @ApiResponse(responseCode = "200", description = "ok")
//    @ApiResponse(responseCode = "400", description = "hmm")//todo
    ResponseEntity deletePerson(long id);
}
