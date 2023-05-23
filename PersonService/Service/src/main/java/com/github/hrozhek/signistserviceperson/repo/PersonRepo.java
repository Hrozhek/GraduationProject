package com.github.hrozhek.signistserviceperson.repo;

import com.github.hrozhek.signistservicepersondata.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<PersonEntity, Long> {
}
