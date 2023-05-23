package com.github.hrozhek.signistappsignaturist.dto;

import lombok.Data;

@Data
public class VerificationRequest {

    private long personId;
    private long userId;
    private ImageRequest imageRequest;
}
