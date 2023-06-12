package com.app.tutorial.springbootschoolsortingandpagination.repository;

import com.app.tutorial.springbootschoolsortingandpagination.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {}
