package com.github.hrozhek.signistappsignaturist.service;

import com.github.hrozhek.signistappsignaturist.dto.AddPersonRequest;
import com.github.hrozhek.signistappsignaturist.dto.PersonResponse;

import java.util.List;

public interface PersonService {

    List<PersonResponse> getAll();

    PersonResponse getPerson(long personId);

    PersonResponse addPerson(AddPersonRequest person);

    void deletePerson(long id);

}
