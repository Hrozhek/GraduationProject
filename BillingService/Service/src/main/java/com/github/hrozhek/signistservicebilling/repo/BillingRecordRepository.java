package com.github.hrozhek.signistservicebilling.repo;

import com.github.hrozhek.signistservicebilling.model.BillingRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRecordRepository extends JpaRepository<BillingRecordEntity, Long> {

}
