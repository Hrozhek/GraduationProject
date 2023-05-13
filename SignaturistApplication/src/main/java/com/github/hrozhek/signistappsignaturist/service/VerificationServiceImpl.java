package com.github.hrozhek.signistappsignaturist.service;

public class VerificationServiceImpl implements VerificationService {

    public Object verifyPerson(long personId, Object signature) {
        //check personId exists
        //check personId contain model
        //sync calls:
        // try {} 1)reserve the engine
        // 2)billing, security - todo
        // 3)sign detector call so it may FAILURE next steps
        // 4)spoofer (depends on config - either allow spoofed with history or reject), and config can be in spoofer so it decide if we should return FAILURE
        // 5) call engine
        return null;//score
        // finally {unreserve engine + save to history result}
    }
}
