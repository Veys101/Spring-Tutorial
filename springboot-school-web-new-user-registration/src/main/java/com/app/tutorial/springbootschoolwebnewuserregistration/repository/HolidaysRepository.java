package com.app.tutorial.springbootschoolwebnewuserregistration.repository;

import com.app.tutorial.springbootschoolwebnewuserregistration.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
