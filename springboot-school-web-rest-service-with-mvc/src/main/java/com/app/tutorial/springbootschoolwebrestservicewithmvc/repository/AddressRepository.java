package com.app.tutorial.springbootschoolwebrestservicewithmvc.repository;

import com.app.tutorial.springbootschoolwebrestservicewithmvc.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {}
