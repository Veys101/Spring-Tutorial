package com.app.tutorial.springbootschoolwebpropertiesconfig.repository;

import com.app.tutorial.springbootschoolwebpropertiesconfig.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
