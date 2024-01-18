package com.example.testmoduel4.service.impl;

import com.example.testmoduel4.model.Country;
import com.example.testmoduel4.repository.ICountryRepository;
import com.example.testmoduel4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceImpl implements ICountryService {
    @Autowired
    private ICountryRepository countryRepository;
    @Override
    public List<Country> getCountryList() {
        return countryRepository.findAll();
    }
}
