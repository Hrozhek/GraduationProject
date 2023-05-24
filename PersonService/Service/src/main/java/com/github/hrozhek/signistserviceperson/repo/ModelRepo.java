package com.github.hrozhek.signistserviceperson.repo;

import com.github.hrozhek.signistservicepersondata.model.ModelEntity;
import com.github.hrozhek.signistservicepersondata.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<ModelEntity, Long> {

    ModelEntity findByPersonId(long personId);
}
