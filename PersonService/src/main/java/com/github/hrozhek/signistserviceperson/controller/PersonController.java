package com.github.hrozhek.signistserviceperson.controller;

import java.util.List;

public interface PersonController {

    List<Object> getPeople();

    Object getPerson(long personId);

    Object deletePerson(long personId);

    Object register(Object person);

    Object update(long personId, Object person);

}
