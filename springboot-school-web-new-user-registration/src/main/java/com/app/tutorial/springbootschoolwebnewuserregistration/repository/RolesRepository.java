package com.app.tutorial.springbootschoolwebnewuserregistration.repository;

import com.app.tutorial.springbootschoolwebnewuserregistration.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository <Roles, Integer> {
    Roles getByRoleName(String roleName);
}
