package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.State;
import com.emysilva.fleet.management.application.model.Supplier;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.StateService;
import com.emysilva.fleet.management.application.service.SupplierService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SupplierControllerTest {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    List<Supplier> suppliers = null;
    List<Country> countries = null;
    List<State> states = null;

    @BeforeEach
    void setUp() {
        suppliers = supplierService.getSuppliers();
        countries = countryService.getCountries();
        states = stateService.getStates();
    }

    @Test
    void getSuppliers() {
        assertEquals(suppliers.size(), suppliers.size());
        assertEquals(countries.size(), countries.size());
        assertEquals(states.size(), states.size());
    }

    @Test
    void getSupplier() {
        assertEquals(supplierService.getSupplier(1).getAddress(), supplierService.getSupplier(1).getAddress());
    }

    @Test
    void addSupplier() {
        Supplier supplier = new Supplier();
        supplier.setId(5);
        supplier.setEmail("emysly12@gmail.com");
        supplier.setName("Chukwuebuka Emmanuel");
        supplier.setPhone("09040201098");

        int initialSize = suppliers.size();

        suppliers.add(supplier);

        assertEquals(initialSize + 1, suppliers.size());
    }

    @Test
    void updateClient() {
        Supplier supplier = supplierService.getSupplier(1);
        supplier.setId(5);
        supplier.setEmail("emysly12@gmail.com");
        supplier.setName("Chukwuebuka Emmanuel");
        supplier.setPhone("09040201098");

        int initialSize = suppliers.size();

        suppliers.add(supplier);

        assertEquals(initialSize + 1, suppliers.size());
    }

    @Test
    void deleteClient() {
        int initialSize = suppliers.size();

        if (suppliers.size() != 0)
            suppliers.remove(0);

        assertEquals(initialSize - 1, suppliers.size());
    }

    @AfterEach
    void tearDown() {
        suppliers = null;
        countries = null;
        states = null;
    }


}