package com.github.hrozhek.signistappsignaturist.dto;
import lombok.Data;

@Data
public class AddPersonRequest {

    String name;
    Long docNumber;
    Boolean pdAgreement;
}
