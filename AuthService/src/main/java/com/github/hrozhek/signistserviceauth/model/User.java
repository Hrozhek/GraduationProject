package com.github.hrozhek.signistserviceauth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.github.hrozhek.signistserviceauth.model.User.TABLE_NAME;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TABLE_NAME)
public class User {

    static final String TABLE_NAME = "user";
    static final String ID = "id";
    static final String NAME = "name";
    static final String LOGIN = "login";
    static final String PASSWORD = "password";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private Long id;

    @Column(name = NAME)
    private String name;

    @Column(name = LOGIN)
    private String login;

    @Column(name = PASSWORD)
    private String password;

}
