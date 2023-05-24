package com.github.hrozhek.signistappsignaturist.service;

import com.github.hrozhek.signist.service.person.PersonOuterClass;
import com.github.hrozhek.signist.service.person.PersonServiceGrpc;
import com.github.hrozhek.signistappsignaturist.dto.AddPersonRequest;
import com.github.hrozhek.signistappsignaturist.dto.PersonResponse;
import com.github.hrozhek.signistappsignaturist.grpcmapper.PersonMapper;
import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service //defined in config
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private static final Empty EMPTY = Empty.newBuilder().build();

    private final PersonServiceGrpc.PersonServiceBlockingStub client;

    @Override
    public List<PersonResponse> getAll() {
        var list = client.getPeople(EMPTY);
        return PersonMapper.mapPeople(list.getPeopleList());
    }

    @Override
    public PersonResponse getPerson(long personId) {
        var person = client.getPerson(PersonOuterClass.PersonId.newBuilder().setPersonId(personId).build());
        return PersonMapper.mapPerson(person);
    }

    @Override
    public PersonResponse addPerson(AddPersonRequest request) {
        //todo check all fields
        var person = client.registerPerson(PersonOuterClass.PersonMessage.newBuilder()
                .setName(request.getName())
                .setDocNumber(request.getDocNumber())
                .setPdAgreement(request.getPdAgreement())
                .build());
        return PersonMapper.mapPerson(person);
    }

    @Override
    public void deletePerson(long id) {
        client.deletePerson(PersonOuterClass.PersonId.newBuilder().setPersonId(id).build());

    }
}
