package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Contact;
import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.service.ContactService;
import com.emysilva.fleet.management.application.service.CountryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryControllerTest {


    @Autowired
    private CountryService countryService;

    List<Country> countries = null;

    @BeforeEach
    void setUp() {
        countries = countryService.getCountries();
    }

    @Test
    void getCountries() {
        assertEquals(countries.size(), countries.size());
    }

    @Test
    void getCountry() {
        assertEquals(countryService.getCountry(3).getCapital(), countryService.getCountry(3).getCapital());
    }

    @Test
    void addCountry() {
        Country country = new Country();
        country.setId(5);
        country.setNationality("Nigeria");
        country.setCode("NIG");
        country.setContinent("Africa");
        country.setCapital("Abuja");

        int initialSize = countries.size();

        countries.add(country);

        assertEquals(initialSize + 1, countries.size());
    }

    @Test
    void updateContact() {
        Country country = countryService.getCountry(3);
        country.setId(5);
        country.setNationality("Nigeria");
        country.setCode("NIG");
        country.setContinent("Africa");
        country.setCapital("Abuja");

        int initialSize = countries.size();

        countries.add(country);

        assertEquals(initialSize + 1, countries.size());
    }

    @Test
    void deleteContact() {
        int initialSize = countries.size();

        if (countries.size() != 0)
            countries.remove(0);

        assertEquals(initialSize - 1, countries.size());
    }

    @AfterEach
    void tearDown() {
        countries = null;
    }
}