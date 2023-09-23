package com.app.tutorial.springbootschoolwebactuator.repository;

import com.app.tutorial.springbootschoolwebactuator.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {}
