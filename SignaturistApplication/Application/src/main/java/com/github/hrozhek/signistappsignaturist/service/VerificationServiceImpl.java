package com.github.hrozhek.signistappsignaturist.service;

import com.github.hrozhek.signist.ml.detector.Detector;
import com.github.hrozhek.signist.ml.detector.DetectorServiceGrpc;
import com.github.hrozhek.signist.ml.spoofer.Spoofer;
import com.github.hrozhek.signist.ml.spoofer.SpooferServiceGrpc;
import com.github.hrozhek.signist.ml.verificator.Verificator;
import com.github.hrozhek.signist.ml.verificator.VerificatorServiceGrpc;
import com.github.hrozhek.signist.service.billing.BillingServiceGrpc;
import com.github.hrozhek.signist.service.person.ModelServiceGrpc;
import com.github.hrozhek.signist.service.person.PersonServiceGrpc;
import com.github.hrozhek.signistappsignaturist.dto.VerificationRequest;
import com.github.hrozhek.signistappsignaturist.grpcmapper.BillingMapper;
import com.github.hrozhek.signistappsignaturist.grpcmapper.DetectorMapper;
import com.github.hrozhek.signistappsignaturist.grpcmapper.SpooferRequestMapper;
import com.github.hrozhek.signistappsignaturist.grpcmapper.VerificatorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.github.hrozhek.signistappsignaturist.grpcmapper.PersonMapper.mapPersonId;

//@Service //defined in config
@RequiredArgsConstructor
public class VerificationServiceImpl implements VerificationService {

    private final SpooferServiceGrpc.SpooferServiceBlockingStub spooferClient;

    private final DetectorServiceGrpc.DetectorServiceBlockingStub detectorClient;

    private final VerificatorServiceGrpc.VerificatorServiceBlockingStub verificatorClient;

    private final PersonServiceGrpc.PersonServiceBlockingStub personClient;

    private final ModelServiceGrpc.ModelServiceBlockingStub modelClient;

    private final BillingServiceGrpc.BillingServiceBlockingStub billingClient;

    @Override
    public boolean verifyPerson(VerificationRequest request) {
        boolean positive = false;
//        personClient.getPerson(); //check personId exists  // check personId contain model
        long modelId = getVerificationModelId(request);
        try {
            if (modelId < 1) {
                throw new RuntimeException("model id not found");
            }
            verificatorClient.reserve(VerificatorMapper.mapModelData(modelId));
            Detector.DetectionResult detectionResult = detectorClient.detect(DetectorMapper.mapRequest(request.getImageRequest()));
            // todo 4)spoofer (depends on config - either allow spoofed with history or reject), and config can be in spoofer so it decide if we should return FAILURE
            Spoofer.SpoofingResult spoofingResult = spooferClient.check(SpooferRequestMapper.mapRequest(request.getImageRequest()));
            Verificator.VerificationResult verificationResult = verificatorClient.verify(VerificatorMapper.mapRequest(modelId, request.getImageRequest()));
            positive = true;
            return verificationResult.getStatus() == Verificator.VerificationResult.Status.SUCCESS;
        } finally {
            billingClient.writeTransaction(BillingMapper.mapAccessRequest(request, modelId, positive));
            verificatorClient.free(VerificatorMapper.mapModelData(modelId));

        }
    }

    private long getVerificationModelId(VerificationRequest request) {
        try {
            return modelClient.getModel(mapPersonId(request.getPersonId())).getModelId().getModelId();
        } catch (Exception e) {
            return -1L;
        }
    }
}
