package com.github.hrozhek.graduation.controller;

import com.github.hrozhek.graduation.dto.CompareSignatureRequest;
import com.github.hrozhek.graduation.service.HwAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.commons.lang3.Validate.notEmpty;

@RestController
@RequestMapping(path = "/handwriting", consumes = MediaType.APPLICATION_JSON_VALUE)
public class HwAppControllerImpl implements HwAppController {

    private final HwAppService service;

    @Autowired
    public HwAppControllerImpl(HwAppService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/compare")
    public ResponseEntity<Double> compare(@RequestBody CompareSignatureRequest request) {
        String ref;
        String presented;
        try {
            ref = notEmpty(request.getReference().getBase64Image());
            presented = notEmpty(request.getPresented().getBase64Image());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();//todo
        }
        return ResponseEntity.ok(service.compare(ref, presented));//todo try catch?
    }

}
