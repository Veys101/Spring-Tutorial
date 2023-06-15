package com.app.tutorial.springbootschoolwebcustomqueryjpa.repository;

import com.app.tutorial.springbootschoolwebcustomqueryjpa.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {}
