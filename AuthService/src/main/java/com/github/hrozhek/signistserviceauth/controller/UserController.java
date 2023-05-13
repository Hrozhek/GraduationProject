package com.github.hrozhek.signistserviceauth.controller;

import java.util.List;

public interface UserController {

    Object register(Object user); //todo login, pass, ... - should be used under the client creds

    Object auth(Object credentials); //todo

    Object endSession(Object sessionId); //todo

    Object checkSession(Object sessionId);
}
