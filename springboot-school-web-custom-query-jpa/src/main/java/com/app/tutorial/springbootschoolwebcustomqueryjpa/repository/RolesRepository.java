package com.app.tutorial.springbootschoolwebcustomqueryjpa.repository;

import com.app.tutorial.springbootschoolwebcustomqueryjpa.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository <Roles, Integer> {
    Roles getByRoleName(String roleName);
}
