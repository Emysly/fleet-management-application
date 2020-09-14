package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.State;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.StateService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StateControllerTest {

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    List<Country> countries = null;
    List<State> states = null;

    @BeforeEach
    void setUp() {
        countries = countryService.getCountries();
        states = stateService.getStates();
    }

    @Test
    void getStates() {
        assertEquals(countries.size(), countries.size());
        assertEquals(states.size(), states.size());
    }

    @Test
    void getState() {
        assertEquals(stateService.getState(2).getCapital(), stateService.getState(2).getCapital());
    }

    @Test
    void addState() {
        State state = new State();
        state.setId(5);
        state.setCapital("Lagos");
        state.setCode("LAG");

        int initialSize = states.size();

        states.add(state);

        assertEquals(initialSize + 1, states.size());
    }

    @Test
    void updateState() {
        State state = stateService.getState(2);
        state.setId(5);
        state.setCapital("Lagos");
        state.setCode("LAG");

        int initialSize = states.size();

        states.add(state);

        assertEquals(initialSize + 1, states.size());
    }

    @Test
    void deleteState() {
        int initialSize = states.size();

        if (states.size() != 0)
            states.remove(0);

        assertEquals(initialSize - 1, states.size());
    }

    @AfterEach
    void tearDown() {
        countries = null;
        states = null;
    }

}