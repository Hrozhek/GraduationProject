package com.github.hrozhek.signistmlverificatorservice.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ModelEntity.TABLE_NAME)
public class ModelEntity { //TODO - metainfo at least at the beginning

    static final String TABLE_NAME = "model";
    static final String ID = "id";
    static final String PERSON_ID = "person_id";
    static final String MODEL_REF = "model_ref";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private Long id;

//    @JoinColumn
//    @OneToOne
    @Column(name = PERSON_ID)
    private Long personId;

    @Column(name = MODEL_REF)
    private String modelRef;
}
