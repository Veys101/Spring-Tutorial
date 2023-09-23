package com.app.tutorial.springbootschoolwebactuator.repository;

import com.app.tutorial.springbootschoolwebactuator.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {}
