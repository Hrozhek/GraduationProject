package com.github.hrozhek.signaturist.controller;

import com.github.hrozhek.signaturist.dto.CompareSignatureRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface HwAppController {

//    @Operation todo
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "400", description = "empty data in request")
    ResponseEntity<Double> compare(CompareSignatureRequest request);
}
