package com.github.hrozhek.signistserviceperson.service;

import java.util.List;

public interface PersonService {

    List<Object> getPeople();

    Object getPerson(long personId);

    Object deletePerson(long personId);

    Object register(Object person);

    Object update(long personId, Object person);
}
