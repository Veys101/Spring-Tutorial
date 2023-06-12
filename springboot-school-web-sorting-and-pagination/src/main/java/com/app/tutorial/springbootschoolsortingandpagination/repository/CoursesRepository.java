package com.app.tutorial.springbootschoolsortingandpagination.repository;

import com.app.tutorial.springbootschoolsortingandpagination.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {}
