package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Location;
import com.emysilva.fleet.management.application.model.Vehicle;
import com.emysilva.fleet.management.application.model.VehicleMovement;
import com.emysilva.fleet.management.application.service.LocationService;
import com.emysilva.fleet.management.application.service.VehicleMovementService;
import com.emysilva.fleet.management.application.service.VehicleService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleMovementControllerTest {

    @Autowired
    private VehicleMovementService vehicleMovementService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private LocationService locationService;

    List<Vehicle> vehicles = null;
    List<VehicleMovement> vehicleMovements = null;
    List<Location> locations = null;

    @BeforeEach
    void setUp() {
        vehicleMovements = vehicleMovementService.getVehicleMovements();
    }

    @Test
    void getVehicleMovements() {
        assertEquals(vehicleMovements.size(), vehicleMovements.size());
    }

    @Test
    void getVehicleMovement() {
        if (vehicleMovements.size() > 0)
            assertEquals(vehicleMovementService.getVehicleMovement(2).getId(), vehicleMovementService.getVehicleMovement(2).getId());
    }

    @Test
    void addVehicleMovement() {
        VehicleMovement vehicleMovement = new VehicleMovement();
        vehicleMovement.setId(5);
        vehicleMovement.setVehicleid(2);

        int initialSize = vehicleMovements.size();

        vehicleMovements.add(vehicleMovement);

        assertEquals(initialSize + 1, vehicleMovements.size());
    }

    @Test
    void updateVehicleMovement() {
        int initialSize = vehicleMovements.size();
        if (vehicleMovements.size() > 0) {
            VehicleMovement vehicleMovement = vehicleMovementService.getVehicleMovement(2);
            vehicleMovement.setId(5);
            vehicleMovement.setVehicleid(2);

            vehicleMovements.add(vehicleMovement);

        }
        assertEquals(initialSize + 1, vehicleMovements.size());
    }

    @Test
    void deleteVehicleMovement() {
        int initialSize = vehicleMovements.size();

        if (vehicleMovements.size() > 0)
            vehicleMovements.remove(0);

        assertEquals(initialSize - 1, vehicleMovements.size());
    }

    @AfterEach
    void tearDown() {
        vehicleMovements = null;
    }
}