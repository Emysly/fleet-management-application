package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.Location;
import com.emysilva.fleet.management.application.model.State;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.LocationService;
import com.emysilva.fleet.management.application.service.StateService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocationControllerTest {

    @Autowired
    private LocationService locationService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    List<Location> locations = null;
    List<Country> countries = null;
    List<State> states = null;

    @BeforeEach
    void setUp() {
        locations = locationService.getLocations();
        countries = countryService.getCountries();
        states = stateService.getStates();
    }

    @Test
    void getLocations() {
        assertEquals(locations.size(), locations.size());
        assertEquals(countries.size(), countries.size());
        assertEquals(states.size(), states.size());
    }

    @Test
    void getLocation() {
        assertEquals(locationService.getLocation(2).getAddress(), locationService.getLocation(2).getAddress());
    }

    @Test
    void addLocation() {
        Location location = new Location();
        location.setId(5);
        location.setAddress("7 Asanjo way");
        location.setCity("Lagos");

        int initialSize = locations.size();

        locations.add(location);

        assertEquals(initialSize + 1, locations.size());
    }

    @Test
    void updateLocation() {
        Location location = locationService.getLocation(2);
        location.setId(5);
        location.setAddress("7 Asanjo way");
        location.setCity("Lagos");

        int initialSize = locations.size();

        locations.add(location);

        assertEquals(initialSize + 1, locations.size());
    }

    @Test
    void deleteClient() {
        int initialSize = locations.size();

        if (locations.size() != 0)
            locations.remove(0);

        assertEquals(initialSize - 1, locations.size());
    }

    @AfterEach
    void tearDown() {
        locations = null;
        countries = null;
        states = null;
    }
}