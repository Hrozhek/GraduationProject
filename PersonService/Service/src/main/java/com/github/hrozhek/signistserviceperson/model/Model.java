package com.github.hrozhek.signistserviceperson.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.github.hrozhek.signistserviceperson.model.Model.TABLE_NAME;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TABLE_NAME)
public class Model { //TODO - metainfo at least at the beginning

    static final String TABLE_NAME = "model";
    static final String ID = "id";

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
}
