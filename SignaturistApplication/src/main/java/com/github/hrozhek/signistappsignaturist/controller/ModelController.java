package com.github.hrozhek.signistappsignaturist.controller;

import java.util.List;


//todo id сессии, и из нее берем
public interface ModelController {

    List<Object> getModels(); //todo check PersonService

    /*void*/ Object addModel(long personId, Object image); //todo personId matters

    /*void*/ Object enrichModel(long personId, Object image); //todo only personId matters

    /*void*/ Object deleteModel(long id);
}
