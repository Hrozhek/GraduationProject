package com.github.hrozhek.signistserviceperson.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.github.hrozhek.signistserviceperson.model.Person.TABLE_NAME;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TABLE_NAME)
public class Person {

    static final String TABLE_NAME = "person";
    static final String ID = "id";
    static final String NAME = "name";
    static final String DOC_NUMBER = "doc_number";
    static final String PD_AGREEMENT = "personal_data_agreement";
    static final String MODEL = "model";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private Long id;

    @Column(name = NAME)
    private String name;

    @Column(name = DOC_NUMBER)
    private Long docNumber;

    @Column(name = PD_AGREEMENT)
    private boolean pdAgreement;

    @OneToOne
    @JoinColumn(name = MODEL)
    private Model model;
}