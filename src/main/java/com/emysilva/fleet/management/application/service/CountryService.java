package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public Country getCountry(int id) {
        return countryRepository.findById(id).orElseThrow(() -> new NoSuchDataException("country with id: " + id + "not found"));
    }

    public void deleteCountry(int id) {
       Country countryToDelete = countryRepository.findById(id).orElseThrow(() -> new NoSuchDataException("country with id: " + id + "not found"));
       countryRepository.delete(countryToDelete);
    }
}
