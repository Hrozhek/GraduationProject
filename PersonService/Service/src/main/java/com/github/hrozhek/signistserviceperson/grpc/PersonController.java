package com.github.hrozhek.signistserviceperson.grpc;

import java.util.List;

public interface PersonController { //todo it was designed as REST mock

    List<Object> getPeople();

    Object getPerson(long personId);

    Object deletePerson(long personId);

    Object register(Object person);

    Object update(long personId, Object person);

}
