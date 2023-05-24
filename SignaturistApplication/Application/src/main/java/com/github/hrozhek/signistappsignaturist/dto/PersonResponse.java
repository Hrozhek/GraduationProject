package com.github.hrozhek.signistappsignaturist.dto;
import lombok.Data;

@Data
public class PersonResponse {

    long id;
    String name;
    Long docNumber;
    Boolean pdAgreement;
}
