package com.github.hrozhek.signistappsignaturist.controller;

import java.util.List;

public interface VerificationController {

    List<Object> getHistory(long personId); //todo e.g. userId timestamp result - success/failure (in case of exceptions) and score if succeeded etc.

    Object verify(long personId, Object signature); // todo - должен остаться в истории и быть доступен результат сравнения

    //todo нужно ли хранить переданные образцы? Как будет происходить enrich модели

    //todo а может тут аналог транзакций ввести. Но начать можно и с онлайн верификации
}
