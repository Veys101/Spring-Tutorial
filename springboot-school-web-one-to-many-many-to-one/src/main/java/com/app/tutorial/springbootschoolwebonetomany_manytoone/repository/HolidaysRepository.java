package com.app.tutorial.springbootschoolwebonetomany_manytoone.repository;

import com.app.tutorial.springbootschoolwebonetomany_manytoone.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
