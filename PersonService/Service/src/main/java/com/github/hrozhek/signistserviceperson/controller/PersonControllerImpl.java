package com.github.hrozhek.signistserviceperson.controller;

import com.github.hrozhek.signist.service.person.PersonServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
public class PersonControllerImpl extends PersonServiceGrpc.PersonServiceImplBase implements PersonController {

    @Override
    public List<Object> getPeople() {
        return null;
    }

    @Override
    public Object getPerson(long personId) {
        return null;
    }

    @Override
    public Object deletePerson(long personId) {
        return null;
    }

    @Override
    public Object register(Object person) {
        return null;
    }

    @Override
    public Object update(long personId, Object person) {
        return null;
    }
}
