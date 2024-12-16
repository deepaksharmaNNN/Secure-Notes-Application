package com.deepak.sharma.securenotes.repository;

import com.deepak.sharma.securenotes.enums.AppRole;
import com.deepak.sharma.securenotes.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole roleName);
}
