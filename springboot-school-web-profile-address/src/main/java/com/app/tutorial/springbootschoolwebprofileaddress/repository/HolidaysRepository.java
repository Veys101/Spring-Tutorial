package com.app.tutorial.springbootschoolwebprofileaddress.repository;

import com.app.tutorial.springbootschoolwebprofileaddress.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
