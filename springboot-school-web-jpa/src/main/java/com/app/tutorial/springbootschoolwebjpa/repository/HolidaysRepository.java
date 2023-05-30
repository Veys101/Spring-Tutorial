package com.app.tutorial.springbootschoolwebjpa.repository;

import com.app.tutorial.springbootschoolwebjpa.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
