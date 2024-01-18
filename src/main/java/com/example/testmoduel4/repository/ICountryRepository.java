package com.example.testmoduel4.repository;

import com.example.testmoduel4.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country, Long> {

}
