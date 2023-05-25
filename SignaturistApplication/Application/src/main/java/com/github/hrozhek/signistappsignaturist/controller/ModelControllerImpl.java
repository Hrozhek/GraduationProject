package com.github.hrozhek.signistappsignaturist.controller;

import com.github.hrozhek.signistappsignaturist.dto.ModelResponse;
import com.github.hrozhek.signistappsignaturist.dto.RegisterModelRequest;
import com.github.hrozhek.signistappsignaturist.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/model", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ModelControllerImpl implements ModelController {

    private final ModelService service;

    @Autowired
    public ModelControllerImpl(ModelService service) {
        this.service = service;
    }

    @Override
    @GetMapping(path = "/{personId}")
    public ResponseEntity<ModelResponse> getModel(@PathVariable long personId) {
        return ResponseEntity.ok(service.getModel(personId));
    }

    @Override
    @PostMapping(path = "/{personId}")
    public ResponseEntity<ModelResponse> addModel(@PathVariable long personId) {
        return ResponseEntity.ok(service.addModel(personId));
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteModel(@PathVariable long id) {
        service.deleteModel(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PostMapping(path = "/register")
    public ResponseEntity<Long> registerModel(@RequestBody RegisterModelRequest request) {
        return ResponseEntity.ok(service.register(request));
    }
}
