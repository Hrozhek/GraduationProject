package com.github.hrozhek.signistappsignaturist.grpcmapper;

import com.github.hrozhek.signist.service.person.PersonOuterClass;

public class PersonMapper {

    private PersonMapper() {

    }

    public static PersonOuterClass.PersonId mapPersonId(long id) {
        return PersonOuterClass.PersonId.newBuilder().setPersonId(id).build();
    }
}
