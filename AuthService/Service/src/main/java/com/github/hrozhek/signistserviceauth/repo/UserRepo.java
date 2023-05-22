package com.github.hrozhek.signistserviceauth.repo;

import com.github.hrozhek.signistserviceauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
