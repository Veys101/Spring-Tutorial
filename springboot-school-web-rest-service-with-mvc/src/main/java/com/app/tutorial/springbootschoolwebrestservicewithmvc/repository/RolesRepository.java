package com.app.tutorial.springbootschoolwebrestservicewithmvc.repository;

import com.app.tutorial.springbootschoolwebrestservicewithmvc.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository <Roles, Integer> {
    Roles getByRoleName(String roleName);
}
