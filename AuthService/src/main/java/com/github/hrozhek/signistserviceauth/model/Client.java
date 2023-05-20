package com.github.hrozhek.signistserviceauth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.github.hrozhek.signistserviceauth.model.Client.TABLE_NAME;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TABLE_NAME)
public class Client {

    static final String TABLE_NAME = "client";
    static final String ID = "id";
    static final String TITLE = "title";
    static final String LOGIN = "login";
    static final String PASSWORD = "password";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private Long id;

    @Column(name = TITLE)
    private String title;

    @Column(name = LOGIN)
    private String login;

    @Column(name = PASSWORD)
    private String password; //todo salty hash

//    @Column(name = "company_id")
//    private String companyId;
//
//    @Column(name = "country_code")
//    private int countryCode;

}
