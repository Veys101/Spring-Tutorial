package com.app.tutorial.springbootschoolweblogging.repository;

import com.app.tutorial.springbootschoolweblogging.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {}
