package com.app.tutorial.springbootschoolwebrestserviceconsuming.repository;

import com.app.tutorial.springbootschoolwebrestserviceconsuming.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {}
