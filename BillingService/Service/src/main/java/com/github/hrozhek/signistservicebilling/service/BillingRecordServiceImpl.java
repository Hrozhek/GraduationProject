package com.github.hrozhek.signistservicebilling.service;

import com.github.hrozhek.signistservicebilling.model.BillingRecordEntity;
import com.github.hrozhek.signistservicebilling.repo.BillingRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BillingRecordServiceImpl implements BillingRecordService {

    private final BillingRecordRepository repo;

    @Override
    public BillingRecordEntity addRecord(BillingRecordEntity record) {
        //todo service actions
        return repo.save(record);
    }
}
