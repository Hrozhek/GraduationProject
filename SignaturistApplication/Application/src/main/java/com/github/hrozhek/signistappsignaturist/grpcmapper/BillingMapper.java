package com.github.hrozhek.signistappsignaturist.grpcmapper;

import com.github.hrozhek.signist.service.billing.Billing;
import com.github.hrozhek.signistappsignaturist.dto.VerificationRequest;

public class BillingMapper {

    private BillingMapper() {

    }

    public static Billing.Request mapAccessRequest(VerificationRequest verificationRequest, long modelId, boolean success) {
        return Billing.Request.newBuilder()
                .setUserId(verificationRequest.getUserId())
                .setModelId(modelId)
                .setStatus(success ? Billing.Status.SUCCESS : Billing.Status.FAILURE)
                .setAction(Billing.Action.ACCESS)
                .build();
    }
}
