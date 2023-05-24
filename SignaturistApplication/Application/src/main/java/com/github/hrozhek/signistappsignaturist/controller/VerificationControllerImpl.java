package com.github.hrozhek.signistappsignaturist.controller;

import com.github.hrozhek.signistappsignaturist.dto.VerificationRequest;
import com.github.hrozhek.signistappsignaturist.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/verification", consumes = MediaType.APPLICATION_JSON_VALUE)
public class VerificationControllerImpl implements VerificationController {

    private final VerificationService service;

    @Autowired
    public VerificationControllerImpl(VerificationService service) {
        this.service = service;
    }


    @Override
    @PostMapping("/verify")
    public ResponseEntity<Boolean> verify(VerificationRequest signature) {
        //todo
        /*
          try {
            ref = notEmpty(request.getReference().getBase64Image());
            presented = notEmpty(request.getPresented().getBase64Image());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();//todo
        }
         */
        return ResponseEntity.ok(service.verifyPerson(signature));
    }
}
