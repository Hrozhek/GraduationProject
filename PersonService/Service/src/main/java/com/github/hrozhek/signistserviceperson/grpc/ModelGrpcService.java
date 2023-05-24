package com.github.hrozhek.signistserviceperson.grpc;

import com.github.hrozhek.signist.service.person.ModelServiceGrpc;
import com.github.hrozhek.signist.service.person.Models;
import com.github.hrozhek.signist.service.person.PersonOuterClass;
import com.github.hrozhek.signistserviceperson.service.ModelService;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ModelGrpcService extends ModelServiceGrpc.ModelServiceImplBase {

    private final ModelService service;

    @Override
    public void getModel(PersonOuterClass.PersonId request, StreamObserver<Models.Model> responseObserver) {

        try {
            var entity = service.getPersonModel(request.getPersonId());
            var modelBuilder = Models.Model.newBuilder()
                    .setModelId(Models.ModelId.newBuilder().setModelId(entity.getId()).build())
                    .setPersonId(entity.getPersonId());
            if (StringUtils.isNotBlank(entity.getModelRef())) {
                modelBuilder.setModelData(entity.getModelRef());
            }
            responseObserver.onNext(modelBuilder.build());
        } catch (Exception e) {
            responseObserver.onError(e);
        }

        super.getModel(request, responseObserver);
    }

    @Override
    public void addModel(Models.ModelAddRequest request, StreamObserver<Models.Model> responseObserver) {
        try {
            //todo any checks that request is correct and no model registered?
            var entity = service.addModel(request.getPersonId().getPersonId());
            var model = Models.Model.newBuilder()
                    .setModelId(Models.ModelId.newBuilder().setModelId(entity.getId()).build())
                    .setPersonId(entity.getPersonId())
                    .build();
            responseObserver.onNext(model);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void updateModel(Models.ModelUpdateRequest request, StreamObserver<Models.Model> responseObserver) {
        //todo currently no metadata to update
        super.updateModel(request, responseObserver);
    }

    @Override
    public void deleteModel(Models.ModelId request, StreamObserver<Empty> responseObserver) {
        try {
            service.deleteModel(request.getModelId());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }
}
