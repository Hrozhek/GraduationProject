package com.github.hrozhek.signistserviceauth.repo;

import com.github.hrozhek.signistserviceauth.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepo extends JpaRepository<Client, Long> {
}
