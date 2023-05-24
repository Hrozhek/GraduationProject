package com.github.hrozhek.signistappsignaturist.dto;

import lombok.Data;

import java.util.Optional;

@Data
public class ModelResponse {

    long id;
    long personId;
    Optional<String> modelRef;
}
