package com.app.tutorial.springbootschoolwebonetomany_manytoone.repository;

import com.app.tutorial.springbootschoolwebonetomany_manytoone.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {}
