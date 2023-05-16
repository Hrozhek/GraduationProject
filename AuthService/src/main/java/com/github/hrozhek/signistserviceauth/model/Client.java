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

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password; //todo salty hash

//    @Column(name = "company_id")
//    private String companyId;
//
//    @Column(name = "country_code")
//    private int countryCode;

}
