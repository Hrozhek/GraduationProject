package com.github.hrozhek.signistmlverificatorservice.repo;

import com.github.hrozhek.signistservicepersondata.model.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<ModelEntity, Long> {
}
