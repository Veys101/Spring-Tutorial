package com.app.tutorial.springbootschoolwebrestserviceconsuming.repository;

import com.app.tutorial.springbootschoolwebrestserviceconsuming.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {}
