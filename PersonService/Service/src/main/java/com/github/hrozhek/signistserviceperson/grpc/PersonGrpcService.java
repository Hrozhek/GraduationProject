package com.github.hrozhek.signistserviceperson.grpc;

import com.github.hrozhek.signist.service.person.PersonOuterClass.*;
import com.github.hrozhek.signist.service.person.PersonServiceGrpc.*;
import com.github.hrozhek.signistserviceperson.model.PersonEntity;
import com.github.hrozhek.signistserviceperson.service.PersonService;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class PersonGrpcService extends PersonServiceImplBase {

    private final PersonService service;

    @Override
    public void getPeople(Empty request, StreamObserver<ListOfPeople> responseObserver) {
        try {
            ListOfPeople response = ListOfPeople.newBuilder()
                    .addAllPeople(service.getPeople().stream().map(this::mapPerson).toList())
                    .build();
            //todo example
//            HelloReply reply = HelloReply.newBuilder()
//                    .setMessage("Hello ==> " + request.getName())
//                    .build();
            responseObserver.onNext(response);
        } catch (Exception e) {
            responseObserver.onError(e);
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getPerson(PersonId request, StreamObserver<Person> responseObserver) {
        PersonEntity person = service.getPerson(request.getPersonId());//todo
//        Person response = Person.newBuilder()
//                .setPersonId(PersonId.newBuilder().setPersonId(person.getId()))
//                        .setPersonMessage(PersonMessage.newBuilder()
//                                .setField())
        super.getPerson(request, responseObserver);
    }

    @Override
    public void deletePerson(PersonId request, StreamObserver<Person> responseObserver) {
        super.deletePerson(request, responseObserver);
    }

    @Override
    public void registerPerson(PersonMessage request, StreamObserver<Person> responseObserver) {
        super.registerPerson(request, responseObserver);
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
                        //set fields)
                        .build())
                .build();
    }
}
