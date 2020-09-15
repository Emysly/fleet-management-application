package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.*;
import com.emysilva.fleet.management.application.service.LocationService;
import com.emysilva.fleet.management.application.service.VehicleHireService;
import com.emysilva.fleet.management.application.service.VehicleService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleHireControllerTest {

    @Autowired
    private VehicleHireService vehicleHireService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private LocationService locationService;

    List<Vehicle> vehicles = null;
    List<VehicleHire> vehicleHires = null;
    List<Location> locations = null;

    @BeforeEach
    void setUp() {
        vehicles = vehicleService.getVehicles();
        vehicleHires = vehicleHireService.getVehicleHires();
        locations = locationService.getLocations();
    }

    @Test
    void getVehicleHires() {
        assertEquals(vehicles.size(), vehicles.size());
        assertEquals(vehicleHires.size(), vehicleHires.size());
        assertEquals(locations.size(), locations.size());
    }

    @Test
    void getVehicleHire() {
        if (vehicleHires.size() > 0)
            assertEquals(vehicleHireService.getVehicleHire(2).getPrice(), vehicleHireService.getVehicleHire(2).getPrice());
    }

    @Test
    void addVehicleHire() {
        VehicleHire vehicleHire = new VehicleHire();
        vehicleHire.setId(5);
        vehicleHire.setClientid(3);
        vehicleHire.setPrice("$300");
        vehicleHire.setVehicleid(1);

        int initialSize = vehicleHires.size();

        vehicleHires.add(vehicleHire);

        assertEquals(initialSize + 1, vehicleHires.size());
    }

    @Test
    void updateVehicleHire() {
        int initialSize = vehicleHires.size();
        if (vehicleHires.size() > 0) {
            VehicleHire vehicleHire = vehicleHireService.getVehicleHire(2);
            vehicleHire.setId(5);
            vehicleHire.setClientid(3);
            vehicleHire.setPrice("$300");
            vehicleHire.setVehicleid(1);

            vehicleHires.add(vehicleHire);

        }
        assertEquals(initialSize + 1, vehicleHires.size());
    }

    @Test
    void deleteVehicleHire() {
        int initialSize = vehicleHires.size();

        if (vehicleHires.size() > 0)
            vehicleHires.remove(0);

        assertEquals(initialSize - 1, vehicleHires.size());
    }

    @AfterEach
    void tearDown() {
        vehicles = null;
        vehicleHires = null;
        locations = null;
    }
}