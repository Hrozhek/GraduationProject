package com.github.hrozhek.signistserviceperson.repo;

import com.github.hrozhek.signistserviceperson.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<Model, Long> {
}
