package com.github.hrozhek.graduation.dto;

import lombok.Data;

@Data
public class CompareSignatureRequest {

    private SignatureRequest reference;
    private SignatureRequest presented;
}
