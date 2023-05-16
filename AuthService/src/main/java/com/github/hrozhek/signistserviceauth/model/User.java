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

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

}
