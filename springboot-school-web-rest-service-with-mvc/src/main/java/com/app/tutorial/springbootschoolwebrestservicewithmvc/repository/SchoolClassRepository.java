package com.app.tutorial.springbootschoolwebrestservicewithmvc.repository;

import com.app.tutorial.springbootschoolwebrestservicewithmvc.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {}
