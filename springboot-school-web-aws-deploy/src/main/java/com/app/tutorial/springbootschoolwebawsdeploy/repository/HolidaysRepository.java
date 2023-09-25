package com.app.tutorial.springbootschoolwebawsdeploy.repository;

import com.app.tutorial.springbootschoolwebawsdeploy.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
