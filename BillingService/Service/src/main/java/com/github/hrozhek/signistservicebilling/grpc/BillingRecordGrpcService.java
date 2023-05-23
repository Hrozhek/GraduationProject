package com.github.hrozhek.signistservicebilling.grpc;

import com.github.hrozhek.signist.service.billing.Billing;
import com.github.hrozhek.signist.service.billing.BillingServiceGrpc;
import com.github.hrozhek.signistservicebilling.model.BillingRecordEntity;
import com.github.hrozhek.signistservicebilling.model.ModelAction;
import com.github.hrozhek.signistservicebilling.model.Status;
import com.github.hrozhek.signistservicebilling.service.BillingRecordService;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class BillingRecordGrpcService extends BillingServiceGrpc.BillingServiceImplBase {

    private final BillingRecordService service;

    @Override
    public void writeTransaction(Billing.Request request, StreamObserver<Empty> responseObserver) {
        BillingRecordEntity entity = new BillingRecordEntity();
        entity.setUserId(request.getUserId());
        entity.setModelId(request.getModelId());
        entity.setAction(mapAction(request.getAction()));
        entity.setStatus(mapStatus(request.getStatus()));
        service.addRecord(entity);
        responseObserver.onCompleted(); //todo error handling
    }

    private ModelAction mapAction(Billing.Action action) {
        return switch (action) {
            case ACCESS -> ModelAction.ACCESS;
            case CREATE -> ModelAction.CREATE;
            case MODIFY -> ModelAction.MODIFY;
            case DELETE -> ModelAction.DELETE;
            case UNRECOGNIZED -> throw new RuntimeException("Unrecognized action"); //todo
        };
    }

    private Status mapStatus(Billing.Status status) {
        return switch (status) {
            case SUCCESS -> Status.SUCCESS;
            case FAILURE -> Status.FAILURE;
            case UNRECOGNIZED -> throw new RuntimeException("Unrecognized status"); //todo
        };
    }
}
