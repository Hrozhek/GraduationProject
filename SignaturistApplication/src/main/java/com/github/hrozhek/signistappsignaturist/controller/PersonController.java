package com.github.hrozhek.signistappsignaturist.controller;

import java.util.List;

public interface PersonController {

    //todo check PersonService

    List<Object> getAll(); //todo paginated

    Object getPerson(long personId);

    /*void*/ Object addPerson(Object person); //todo personId matters

    /*void*/ Object updatePerson(long id, Object person); //todo only personId matters

    /*void*/ Object deletePerson(long id);
}
