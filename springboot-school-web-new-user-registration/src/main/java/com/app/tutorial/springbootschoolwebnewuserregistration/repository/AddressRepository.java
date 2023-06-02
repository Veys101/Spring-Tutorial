package com.app.tutorial.springbootschoolwebnewuserregistration.repository;

import com.app.tutorial.springbootschoolwebnewuserregistration.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {}
