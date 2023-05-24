package com.github.hrozhek.signistappsignaturist.grpcmapper;

import com.github.hrozhek.signist.service.person.PersonOuterClass;
import com.github.hrozhek.signistappsignaturist.dto.PersonResponse;

import java.util.List;

public class PersonMapper {

    private PersonMapper() {

    }

    public static PersonOuterClass.PersonId mapPersonId(long id) {
        return PersonOuterClass.PersonId.newBuilder().setPersonId(id).build();
    }

    public static List<PersonResponse> mapPeople(List<PersonOuterClass.Person> people) {
        return people.stream().map(PersonMapper::mapPerson).toList();
    }

    public static PersonResponse mapPerson(PersonOuterClass.Person person) {
        PersonResponse response = new PersonResponse();
        response.setId(person.getPersonId().getPersonId());
        response.setName(person.getPersonMessage().getName());
        response.setDocNumber(person.getPersonMessage().getDocNumber());
        response.setPdAgreement(person.getPersonMessage().getPdAgreement());
        return response;
    }
}
