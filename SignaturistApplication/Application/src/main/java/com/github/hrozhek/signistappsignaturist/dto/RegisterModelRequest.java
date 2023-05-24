package com.github.hrozhek.signistappsignaturist.dto;
import lombok.Data;

@Data
public class RegisterModelRequest {

    private long modelId;
    private ImageRequest imageRequest;
}
