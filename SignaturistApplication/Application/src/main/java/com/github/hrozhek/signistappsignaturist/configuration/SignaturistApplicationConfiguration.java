package com.github.hrozhek.signistappsignaturist.configuration;

import com.github.hrozhek.signist.ml.detector.DetectorServiceGrpc;
import com.github.hrozhek.signist.ml.spoofer.SpooferServiceGrpc;
import com.github.hrozhek.signist.ml.verificator.VerificatorServiceGrpc;
import com.github.hrozhek.signist.service.billing.BillingServiceGrpc;
import com.github.hrozhek.signist.service.person.ModelServiceGrpc;
import com.github.hrozhek.signist.service.person.PersonServiceGrpc;
import com.github.hrozhek.signistappsignaturist.service.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.client.inject.GrpcClientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@GrpcClientBean(
        clazz = VerificatorServiceGrpc.VerificatorServiceBlockingStub.class,
        beanName = "verificatorStub",
        client = @GrpcClient("verificator")
)
@GrpcClientBean(
        clazz = SpooferServiceGrpc.SpooferServiceBlockingStub.class,
        beanName = "spoofingStub",
        client = @GrpcClient("spoofing")
)
@GrpcClientBean(
        clazz = DetectorServiceGrpc.DetectorServiceBlockingStub.class,
        beanName = "detectorStub",
        client = @GrpcClient("detector")
)
@GrpcClientBean(
        clazz = PersonServiceGrpc.PersonServiceBlockingStub.class,
        beanName = "personStub",
        client = @GrpcClient("person")
)
@GrpcClientBean(
        clazz = ModelServiceGrpc.ModelServiceBlockingStub.class,
        beanName = "modelStub",
        client = @GrpcClient("model")
)
@GrpcClientBean(
        clazz = BillingServiceGrpc.BillingServiceBlockingStub.class,
        beanName = "billingStub",
        client = @GrpcClient("billing")
)
public class SignaturistApplicationConfiguration {

    @Bean
    @Autowired
    PersonService personService(PersonServiceGrpc.PersonServiceBlockingStub client) {
        return new PersonServiceImpl(client);
    }

    @Bean
    @Autowired
    ModelService modelService(ModelServiceGrpc.ModelServiceBlockingStub modelClient,
                              VerificatorServiceGrpc.VerificatorServiceBlockingStub verificatorClient) {
        return new ModelServiceImpl(verificatorClient, modelClient);
    }

    @Bean
    @Autowired
    VerificationService verificationService(
            SpooferServiceGrpc.SpooferServiceBlockingStub spooferClient,
            DetectorServiceGrpc.DetectorServiceBlockingStub detectorClient,
            VerificatorServiceGrpc.VerificatorServiceBlockingStub verificatorClient,
            PersonServiceGrpc.PersonServiceBlockingStub personClient,
            ModelServiceGrpc.ModelServiceBlockingStub modelClient,
            BillingServiceGrpc.BillingServiceBlockingStub billingClient
    ) {
        return new VerificationServiceImpl(spooferClient,
                detectorClient,
                verificatorClient,
                personClient,
                modelClient,
                billingClient);
    }
}
