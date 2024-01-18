package com.example.testmoduel4.repository;

import com.example.testmoduel4.model.City;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICityRepository extends JpaRepository<City, Long> {
    List<City> findAllByNameContainingIgnoreCase( String name);
}
