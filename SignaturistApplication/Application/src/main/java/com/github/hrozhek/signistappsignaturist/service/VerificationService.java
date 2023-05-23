package com.github.hrozhek.signistappsignaturist.service;

import com.github.hrozhek.signistappsignaturist.dto.VerificationRequest;

public interface VerificationService {

    Object verifyPerson(VerificationRequest request);
}
