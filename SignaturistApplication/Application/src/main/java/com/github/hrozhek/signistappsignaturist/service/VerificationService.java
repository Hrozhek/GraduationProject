package com.github.hrozhek.signistappsignaturist.service;

import com.github.hrozhek.signistappsignaturist.dto.VerificationRequest;

public interface VerificationService {

    boolean verifyPerson(VerificationRequest request);
}
