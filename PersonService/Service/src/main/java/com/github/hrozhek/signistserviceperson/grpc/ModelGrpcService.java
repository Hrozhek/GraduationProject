package com.github.hrozhek.signistserviceperson.grpc;

import com.github.hrozhek.signist.service.person.ModelServiceGrpc;
import com.github.hrozhek.signistserviceperson.service.ModelService;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ModelGrpcService extends ModelServiceGrpc.ModelServiceImplBase {

    private final ModelService service;

}
