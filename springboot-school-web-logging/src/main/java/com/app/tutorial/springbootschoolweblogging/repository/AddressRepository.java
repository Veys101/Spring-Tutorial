package com.app.tutorial.springbootschoolweblogging.repository;

import com.app.tutorial.springbootschoolweblogging.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {}
