package com.github.hrozhek.signistappsignaturist.service;

import com.github.hrozhek.signist.ml.verificator.Verificator;
import com.github.hrozhek.signist.ml.verificator.VerificatorServiceGrpc;
import com.github.hrozhek.signist.service.person.ModelServiceGrpc;
import com.github.hrozhek.signist.service.person.Models;
import com.github.hrozhek.signist.service.person.PersonOuterClass;
import com.github.hrozhek.signist.service.person.PersonServiceGrpc;
import com.github.hrozhek.signistappsignaturist.dto.ModelResponse;
import com.github.hrozhek.signistappsignaturist.dto.RegisterModelRequest;
import com.github.hrozhek.signistappsignaturist.grpcmapper.ModelMapper;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import static com.github.hrozhek.signistappsignaturist.util.ByteUtils.convertImage;

@Service
public class ModelServiceImpl implements ModelService {

    @GrpcClient("verificator")
    private VerificatorServiceGrpc.VerificatorServiceBlockingStub verificatorClient;

    @GrpcClient("model")
    private ModelServiceGrpc.ModelServiceBlockingStub modelClient;

    @Override
    public ModelResponse getModel(long personId) {
        var model = modelClient.getModel(PersonOuterClass.PersonId.newBuilder().setPersonId(personId).build());
        return ModelMapper.mapModel(model);
    }

    @Override
    public ModelResponse addModel(long personId) {
        var model = modelClient.addModel(Models.ModelAddRequest.newBuilder()
                .setPersonId(PersonOuterClass.PersonId.newBuilder().setPersonId(personId).build())
                .build());
        return ModelMapper.mapModel(model);
    }

    @Override
    public void deleteModel(long id) {
        modelClient.deleteModel(Models.ModelId.newBuilder().setModelId(id).build());
    }

    @Override
    public long register(RegisterModelRequest request) {
        var result = verificatorClient.register(Verificator.ModelMessage.newBuilder()
                .setModelData(Verificator.ModelData.newBuilder().setModelId(request.getModelId()).build())
                .setImage(Verificator.Image.newBuilder().setData(convertImage(request.getImageRequest().getBase64Image())))
                .build());
        return result.getModelId();
    }
}
