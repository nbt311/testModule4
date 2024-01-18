package com.example.testmoduel4.service;

import com.example.testmoduel4.model.City;

import java.util.List;

public interface ICityService {
    List<City> getAllCities();

    void saveCity(City city);

    void deleteCity(Long id);

    City findCityByCityId(Long id);
    List<City> getAllCityByCityName(String name);
}
