package com.example.AcademiaWeb_App.repository;

import com.example.AcademiaWeb_App.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
