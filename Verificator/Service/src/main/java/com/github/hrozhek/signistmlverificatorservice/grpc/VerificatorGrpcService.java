package com.github.hrozhek.signistmlverificatorservice.grpc;

import com.github.hrozhek.signist.ml.verificator.Verificator;
import com.github.hrozhek.signist.ml.verificator.VerificatorServiceGrpc;
import com.github.hrozhek.signistmlverificatorservice.model.ModelEntity;
import com.github.hrozhek.signistmlverificatorservice.service.VerificatorService;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VerificatorGrpcService extends VerificatorServiceGrpc.VerificatorServiceImplBase {

    private final VerificatorService service;

    @Override
    public void reserve(Verificator.ModelData request, StreamObserver<Empty> responseObserver) {
        service.reserve(request.getModelId());
        responseObserver.onCompleted();
    }

    @Override
    public void register(Verificator.ModelMessage request, StreamObserver<Verificator.ModelData> responseObserver) {
        try {
            ModelEntity model = service.registerModel(request.getModelData().getModelId(),
                    map(request.getImage().getData()));
            var result = Verificator.ModelData.newBuilder().setModelId(model.getId()).build();
            responseObserver.onNext(result);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }

    }

    @Override
    public void verify(Verificator.ModelMessage request, StreamObserver<Verificator.VerificationResult> responseObserver) {
        try {
            boolean answer = service.verify(request.getModelData().getModelId(),
                    map(request.getImage().getData()));
            var result = Verificator.VerificationResult.newBuilder()
                    .setStatus(answer ? Verificator.VerificationResult.Status.SUCCESS
                            : Verificator.VerificationResult.Status.FAILURE)
                    .build();
            responseObserver.onNext(result);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void free(Verificator.ModelData request, StreamObserver<Empty> responseObserver) {
        service.free(request.getModelId());
        responseObserver.onCompleted();
    }

    @SneakyThrows
    private BufferedImage map(ByteString byteString) {
        byte[] bytes = new byte[byteString.size()];
        byteString.copyTo(bytes, 0);
        return ImageIO.read(new ByteArrayInputStream(bytes));
    }
}
