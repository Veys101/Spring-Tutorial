package com.app.tutorial.springbootschoolwebauditing.repository;

import com.app.tutorial.springbootschoolwebauditing.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
