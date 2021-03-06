package com.example.webdesignsquadclientmanager.repository;

import com.example.webdesignsquadclientmanager.entity.ERole;
import com.example.webdesignsquadclientmanager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
g
    Optional<Role> findByName(ERole name);
}
