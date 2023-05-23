package com.github.hrozhek.signistmlspooferservice.grpc;

import com.github.hrozhek.signist.ml.spoofer.Spoofer;
import com.github.hrozhek.signist.ml.spoofer.SpooferServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Random;

@GrpcService
public class SpooferGrpcService extends SpooferServiceGrpc.SpooferServiceImplBase {

    private static final Random random = new Random(42);
    private int counter = 0;

    @Override
    public void check(Spoofer.Image request, StreamObserver<Spoofer.SpoofingResult> responseObserver) {
        var resultBuilder = Spoofer.SpoofingResult.newBuilder();
        var status = Spoofer.SpoofingResult.Status.SUCCESS;
        if (counter == 5) {
            if (random.nextBoolean()) {
//                status = Detector.DetectionResult.Status.FAILURE);
                //todo return error
                responseObserver.onError(new RuntimeException("spoofing failure")); //todo
            }
            counter = 0;
        }
        var result = resultBuilder.setStatus(status).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
}
