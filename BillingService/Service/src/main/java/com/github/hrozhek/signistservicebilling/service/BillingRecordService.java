package com.github.hrozhek.signistservicebilling.service;

import com.github.hrozhek.signistservicebilling.model.BillingRecordEntity;

public interface BillingRecordService {

    BillingRecordEntity addRecord(BillingRecordEntity record);
}
