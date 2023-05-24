package com.github.hrozhek.signistmlsigndetectorservice.grpc;

import com.github.hrozhek.signist.ml.detector.Detector;
import com.github.hrozhek.signist.ml.detector.DetectorServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Random;

@GrpcService
public class DetectorGrpcService extends DetectorServiceGrpc.DetectorServiceImplBase {

    private static final Random random = new Random(42);
    private int counter = 0;

    @Override
    public void detect(Detector.Image request, StreamObserver<Detector.DetectionResult> responseObserver) {
        var resultBuilder = Detector.DetectionResult.newBuilder();
        var status = Detector.DetectionResult.Status.SUCCESS;
        if (counter == 5) {
            if (random.nextBoolean()) {
//                status = Detector.DetectionResult.Status.FAILURE);
                //todo return error
                responseObserver.onError(new RuntimeException("detection failure")); //todo
                counter = 0;
                return;
            }
            counter = 0;
        }
        var result = resultBuilder.setStatus(status).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
}
