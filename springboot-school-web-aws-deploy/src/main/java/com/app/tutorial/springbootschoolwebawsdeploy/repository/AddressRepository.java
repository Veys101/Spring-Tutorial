package com.app.tutorial.springbootschoolwebawsdeploy.repository;

import com.app.tutorial.springbootschoolwebawsdeploy.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {}
