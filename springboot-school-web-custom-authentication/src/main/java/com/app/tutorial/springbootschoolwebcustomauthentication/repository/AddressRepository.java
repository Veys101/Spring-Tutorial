package com.app.tutorial.springbootschoolwebcustomauthentication.repository;

import com.app.tutorial.springbootschoolwebcustomauthentication.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {}
