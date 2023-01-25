package com.github.hrozhek.signaturist.dto;

import lombok.Data;

@Data
public class CompareSignatureRequest {

    private SignatureRequest reference;
    private SignatureRequest presented;
}
