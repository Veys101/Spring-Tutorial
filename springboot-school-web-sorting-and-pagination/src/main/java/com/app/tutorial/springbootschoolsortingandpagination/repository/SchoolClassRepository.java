package com.app.tutorial.springbootschoolsortingandpagination.repository;

import com.app.tutorial.springbootschoolsortingandpagination.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {}
