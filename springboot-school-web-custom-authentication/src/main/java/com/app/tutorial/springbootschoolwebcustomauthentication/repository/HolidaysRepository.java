package com.app.tutorial.springbootschoolwebcustomauthentication.repository;

import com.app.tutorial.springbootschoolwebcustomauthentication.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
