package com.github.hrozhek.signistmlverificatorservice.repo;

import com.github.hrozhek.signistmlverificatorservice.model.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<ModelEntity, Long> {
}
