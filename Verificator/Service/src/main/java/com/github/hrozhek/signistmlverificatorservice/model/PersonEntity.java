package com.github.hrozhek.signistmlverificatorservice.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = PersonEntity.TABLE_NAME)
public class PersonEntity {

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

    //todo
//    @OneToOne
//    @JoinColumn(name = MODEL) //todo how to join
//    private ModelEntity model; //todo fetchtype lazy
}
