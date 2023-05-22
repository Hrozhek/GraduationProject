package com.github.hrozhek.signistserviceperson.service;

import com.github.hrozhek.signistserviceperson.model.PersonEntity;

import java.util.List;

public interface PersonService {

    List<PersonEntity> getPeople();

    PersonEntity getPerson(long personId);

    PersonEntity deletePerson(long personId);

    PersonEntity register(PersonEntity person);

    PersonEntity update(long personId, PersonEntity person); //todo dto here
}
