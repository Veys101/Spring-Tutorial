package com.app.tutorial.springbootschoolwebcustomqueryjpa.repository;

import com.app.tutorial.springbootschoolwebcustomqueryjpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {}
