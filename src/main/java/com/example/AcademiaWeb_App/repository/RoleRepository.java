package com.example.AcademiaWeb_App.repository;

import com.example.AcademiaWeb_App.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
