package com.github.hrozhek.signistserviceauth.controller;

import java.util.List;

public interface ClientController {

    List<Object> getClients(); //todo to use on frontend for log-in

    Object register(Object client); //todo login, pass, ... - should it be available at all? Only under the root session

    Object update(Object clientUpdate); //todo available for the client admin

    Object auth(Object credentials); //todo this method should be used to create users and manage data of organization

    Object endSession(Object sessionId); //todo
}
