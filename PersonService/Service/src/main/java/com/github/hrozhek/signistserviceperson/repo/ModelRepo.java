package com.github.hrozhek.signistserviceperson.repo;

import com.github.hrozhek.signistserviceperson.model.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<ModelEntity, Long> {
}
