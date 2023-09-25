package com.app.tutorial.springbootschoolwebawsdeploy.repository;

import com.app.tutorial.springbootschoolwebawsdeploy.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {}
