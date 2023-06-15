package com.app.tutorial.springbootschoolwebcustomqueryjpa.repository;

import com.app.tutorial.springbootschoolwebcustomqueryjpa.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
