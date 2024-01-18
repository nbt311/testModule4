package com.example.testmoduel4.service.impl;

import com.example.testmoduel4.model.City;
import com.example.testmoduel4.repository.ICityRepository;
import com.example.testmoduel4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {
    @Autowired
    private ICityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public void saveCity(City student) {
        cityRepository.save(student);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City findCityByCityId(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public List<City> getAllCityByCityName(String name) {
        return cityRepository.findAllByNameContainingIgnoreCase(name) ;
    }
}
