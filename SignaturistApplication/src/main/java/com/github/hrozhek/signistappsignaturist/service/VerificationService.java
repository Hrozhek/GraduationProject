package com.github.hrozhek.signistappsignaturist.service;

public interface VerificationService {

    Object verifyPerson(long personId, Object signature);
}
