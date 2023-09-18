package com.app.tutorial.springbootschoolwebpropertiesconfig.repository;

import com.app.tutorial.springbootschoolwebpropertiesconfig.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {}
