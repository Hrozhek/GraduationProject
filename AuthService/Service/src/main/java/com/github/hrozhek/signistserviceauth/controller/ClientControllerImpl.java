package com.github.hrozhek.signistserviceauth.controller;

import com.github.hrozhek.signistserviceauth.dto.ClientDto;
import com.github.hrozhek.signistserviceauth.dto.CredentialsDto;
import com.github.hrozhek.signistserviceauth.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {

    private final ClientService service;

    @Override
    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        return service.getClients();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable long clientId) {

    }

    @Override
    @PostMapping
    public ResponseEntity<ClientDto> register(ClientDto client) {
        return null;
    }

    @Override
    public ClientDto update(ClientDto clientUpdate) {
        return null;
    }

    @Override
    public Object auth(CredentialsDto credentials) {
        return null;
    }

    @Override
    public Object endSession(Object sessionId) {
        return null;
    }
}
