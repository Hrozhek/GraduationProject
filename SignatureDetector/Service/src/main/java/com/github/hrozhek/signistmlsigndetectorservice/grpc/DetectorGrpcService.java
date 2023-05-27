package com.github.hrozhek.signistmlsigndetectorservice.grpc;

import com.github.hrozhek.signist.ml.detector.Detector;
import com.github.hrozhek.signist.ml.detector.DetectorServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@GrpcService
public class DetectorGrpcService extends DetectorServiceGrpc.DetectorServiceImplBase {

    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void detect(Detector.Image request, StreamObserver<Detector.DetectionResult> responseObserver) {
        var resultBuilder = Detector.DetectionResult.newBuilder();
        var status = Detector.DetectionResult.Status.SUCCESS;
        if (counter.get() >= 5) {
//                status = Detector.DetectionResult.Status.FAILURE);
            //todo return error
            counter.set(0);
            responseObserver.onError(new RuntimeException("detection failure")); //todo
            return;
        }
        counter.getAndIncrement();
        var result = resultBuilder.setStatus(status).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
}
