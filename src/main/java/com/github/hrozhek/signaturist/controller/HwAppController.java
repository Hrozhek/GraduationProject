package com.github.hrozhek.signaturist.controller;

import com.github.hrozhek.signaturist.dto.CompareSignatureRequest;
import org.springframework.http.ResponseEntity;

public interface HwAppController {

    ResponseEntity<Double> compare(CompareSignatureRequest request);
}
