package com.github.hrozhek.signistserviceauth.controller;

import com.github.hrozhek.signistserviceauth.dto.ClientDto;
import com.github.hrozhek.signistserviceauth.dto.CredentialsDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientController {

    ResponseEntity<List<ClientDto>> getClients(); //todo to use on frontend for log-in

    ResponseEntity<ClientDto> register(ClientDto client); //todo login, pass, ... - should it be available at all? Only under the root session

    ClientDto update(ClientDto clientUpdate); //todo available for the client admin

    Object auth(CredentialsDto credentials); //todo this method should be used to create users and manage data of organization

    Object endSession(Object sessionId); //todo
}
