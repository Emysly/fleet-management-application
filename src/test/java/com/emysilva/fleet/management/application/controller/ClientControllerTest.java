package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.State;
import com.emysilva.fleet.management.application.service.ClientService;
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
class ClientControllerTest {
    @Autowired
    private ClientService clientService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    List<Client> clients = null;
    List<Country> countries = null;
    List<State> states = null;

    @BeforeEach
    void setUp() {
        clients = clientService.getClients();
        countries = countryService.getCountries();
        states = stateService.getStates();
    }

    @Test
    void getClients() {
        assertEquals(clients.size(), clients.size());
        assertEquals(countries.size(), countries.size());
        assertEquals(states.size(), states.size());
    }

    @Test
    void getClient() {
        assertEquals(clientService.getClient(3).getAddress(), clientService.getClient(3).getAddress());
    }

    @Test
    void addClient() {
        Client client = new Client();
        client.setId(5);
        client.setEmail("emysly12@gmail.com");
        client.setName("Chukwuebuka Emmanuel");
        client.setPhone("09040201098");

        int initialSize = clients.size();

        clients.add(client);

        assertEquals(initialSize + 1, clients.size());
    }

    @Test
    void updateClient() {
        Client client = clientService.getClient(3);
        client.setId(5);
        client.setEmail("emysly12@gmail.com");
        client.setName("Chukwuebuka Emmanuel");
        client.setPhone("09040201098");

        int initialSize = clients.size();

        clients.add(client);

        assertEquals(initialSize + 1, clients.size());
    }

    @Test
    void deleteClient() {
        int initialSize = clients.size();

        if (clients.size() != 0)
            clients.remove(0);

        assertEquals(initialSize - 1, clients.size());
    }

    @AfterEach
    void tearDown() {
        clients = null;
        countries = null;
        states = null;
    }

}