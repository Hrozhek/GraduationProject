package com.github.hrozhek.signistserviceperson.repo;

import com.github.hrozhek.signistserviceperson.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
