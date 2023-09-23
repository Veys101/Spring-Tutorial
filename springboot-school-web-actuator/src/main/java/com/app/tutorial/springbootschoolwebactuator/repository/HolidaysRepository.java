package com.app.tutorial.springbootschoolwebactuator.repository;

import com.app.tutorial.springbootschoolwebactuator.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
