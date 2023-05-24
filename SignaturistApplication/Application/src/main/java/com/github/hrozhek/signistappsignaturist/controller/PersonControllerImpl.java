package com.github.hrozhek.signistappsignaturist.controller;

import com.github.hrozhek.signistappsignaturist.dto.AddPersonRequest;
import com.github.hrozhek.signistappsignaturist.dto.PersonResponse;
import com.github.hrozhek.signistappsignaturist.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonControllerImpl implements PersonController {

    private final PersonService service;

    @Autowired
    public PersonControllerImpl(PersonService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PersonResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonResponse> getPerson(@PathVariable long id) {
        return ResponseEntity.ok(service.getPerson(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<PersonResponse> addPerson(AddPersonRequest person) {
        return ResponseEntity.ok(service.addPerson(person));
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletePerson(@PathVariable long id) {
        service.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
