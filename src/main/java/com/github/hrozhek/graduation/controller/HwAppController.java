package com.github.hrozhek.graduation.controller;

import com.github.hrozhek.graduation.dto.CompareSignatureRequest;
import org.springframework.http.ResponseEntity;

public interface HwAppController {

    ResponseEntity<Double> compare(CompareSignatureRequest request);
}
