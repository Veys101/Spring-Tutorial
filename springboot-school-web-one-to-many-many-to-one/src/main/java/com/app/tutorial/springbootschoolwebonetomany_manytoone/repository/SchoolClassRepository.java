package com.app.tutorial.springbootschoolwebonetomany_manytoone.repository;

import com.app.tutorial.springbootschoolwebonetomany_manytoone.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {}
