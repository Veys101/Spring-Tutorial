package com.app.tutorial.springbootschoolwebrestserviceconsuming.repository;

import com.app.tutorial.springbootschoolwebrestserviceconsuming.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
