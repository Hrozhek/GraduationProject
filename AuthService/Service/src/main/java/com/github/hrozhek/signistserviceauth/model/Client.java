package com.github.hrozhek.signistserviceauth.model;

import javax.persistence.*;
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
    static final String COMPANY_ID = "company_id";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private Long id;

    @Column(name = TITLE)
    private String title;

    @Column(name = COMPANY_ID)
    private String companyId;

}
