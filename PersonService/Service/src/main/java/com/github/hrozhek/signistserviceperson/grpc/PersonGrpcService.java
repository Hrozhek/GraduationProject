package com.github.hrozhek.signistserviceperson.grpc;

import com.github.hrozhek.signist.service.person.PersonOuterClass.*;
import com.github.hrozhek.signist.service.person.PersonServiceGrpc.*;
import com.github.hrozhek.signistserviceperson.model.PersonEntity;
import com.github.hrozhek.signistserviceperson.service.PersonService;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonGrpcService extends PersonServiceImplBase {

    private static final Empty EMPTY = Empty.newBuilder().getDefaultInstanceForType();

    private final PersonService service;

    @Override
    public void getPeople(Empty request, StreamObserver<ListOfPeople> responseObserver) {
        try {
            ListOfPeople response = ListOfPeople.newBuilder()
                    .addAllPeople(service.getPeople().stream().map(this::mapPerson).toList())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void getPerson(PersonId request, StreamObserver<Person> responseObserver) {
        try {
            PersonEntity person = service.getPerson(request.getPersonId());//todo

            Person response = mapPerson(person);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void deletePerson(PersonId request, StreamObserver<Empty> responseObserver) {
        try {
            service.deletePerson(request.getPersonId());
            responseObserver.onNext(EMPTY);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void registerPerson(PersonMessage request, StreamObserver<Person> responseObserver) {
        try {
            PersonEntity entity = new PersonEntity();
            entity.setName(request.getName());
            entity.setDocNumber(request.getDocNumber());
            entity.setPdAgreement(request.getPdAgreement());
            service.register(entity);
            responseObserver.onNext(mapPerson(entity));
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void updatePerson(Person request, StreamObserver<Person> responseObserver) {
        super.updatePerson(request, responseObserver);
    }

    private Person mapPerson(PersonEntity person) {
        return Person.newBuilder()
                .setPersonId(PersonId.newBuilder()
                        .setPersonId(person.getId())
                        .build())
                .setPersonMessage(PersonMessage.newBuilder()
                        .setName(person.getName())
                        .setDocNumber(person.getDocNumber())
                        .setPdAgreement(person.isPdAgreement())
                        .build())
                .build();
    }
}
