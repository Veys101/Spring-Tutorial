package com.app.tutorial.springbootschoolweblogging.repository;

import com.app.tutorial.springbootschoolweblogging.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
