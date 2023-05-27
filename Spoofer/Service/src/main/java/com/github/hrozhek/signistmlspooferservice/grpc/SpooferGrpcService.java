package com.github.hrozhek.signistmlspooferservice.grpc;

import com.github.hrozhek.signist.ml.spoofer.Spoofer;
import com.github.hrozhek.signist.ml.spoofer.SpooferServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@GrpcService
public class SpooferGrpcService extends SpooferServiceGrpc.SpooferServiceImplBase {

    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public void check(Spoofer.Image request, StreamObserver<Spoofer.SpoofingResult> responseObserver) {
        var resultBuilder = Spoofer.SpoofingResult.newBuilder();
        var status = Spoofer.SpoofingResult.Status.SUCCESS;
        if (counter.get() >= 5) {
//                status = Detector.DetectionResult.Status.FAILURE);
            //todo return error
            counter.set(0);
            responseObserver.onError(new RuntimeException("spoofing failure")); //todo
            return;
        }
        counter.getAndIncrement();
        var result = resultBuilder.setStatus(status).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
}
