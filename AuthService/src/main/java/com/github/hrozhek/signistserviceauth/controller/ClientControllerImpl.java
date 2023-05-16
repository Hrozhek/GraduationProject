package com.github.hrozhek.signistserviceauth.controller;

import com.github.hrozhek.signistserviceauth.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {

    private final ClientService service;

    @Override
    public List<Object> getClients() {
        return null;
    }

    @Override
    public Object register(Object client) {
        return null;
    }

    @Override
    public Object update(Object clientUpdate) {
        return null;
    }

    @Override
    public Object auth(Object credentials) {
        return null;
    }

    @Override
    public Object endSession(Object sessionId) {
        return null;
    }
}
