package com.github.hrozhek.signistservicebilling.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.github.hrozhek.signistservicebilling.model.BillingRecordEntity.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingRecordEntity {

    static final String TABLE_NAME = "billing_record";
    static final String ID = "id";
    static final String USER_ID = "user_id";
    static final String MODEL_ID = "model_id";
    static final String ACTION = "action";
    static final String STATUS = "status";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private Long id;

    @Column(name = USER_ID)
    private Long userId;

    @Column(name = MODEL_ID)
    private Long modelId;

    @Column(name = ACTION)
    @Enumerated(value = EnumType.STRING)
    private ModelAction action;

    @Column(name = STATUS)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    //todo timestamp
}
