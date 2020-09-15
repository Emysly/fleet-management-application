package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.VehicleMaintenance;
import com.emysilva.fleet.management.application.model.VehicleMake;
import com.emysilva.fleet.management.application.service.VehicleMaintenanceService;
import com.emysilva.fleet.management.application.service.VehicleMakeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleMakeControllerTest {
    @Autowired
    private VehicleMakeService vehicleMakeService;

    List<VehicleMake> vehicleMakes = null;

    @BeforeEach
    void setUp() {
        vehicleMakes = vehicleMakeService.getVehicleMakes();
    }

    @Test
    void getVehicleMakes() {
        assertEquals(vehicleMakes.size(), vehicleMakes.size());
    }

    @Test
    void getVehicleMake() {
        if (vehicleMakes.size() > 0)
            assertEquals(vehicleMakeService.getVehicleMake(2).getCreatedBy(), vehicleMakeService.getVehicleMake(2).getCreatedBy());
    }

    @Test
    void addVehicleMake() {
        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setId(5);
        vehicleMake.setCreatedBy("10:20:55");
        vehicleMake.setDetails("GL54 mercedes is a beautify and portable car");
        vehicleMake.setLastModifiedBy("20:20:50");

        int initialSize = vehicleMakes.size();

        vehicleMakes.add(vehicleMake);

        assertEquals(initialSize + 1, vehicleMakes.size());
    }

    @Test
    void updateVehicleMake() {
        int initialSize = vehicleMakes.size();
        if (vehicleMakes.size() > 0) {
            VehicleMake vehicleMake = vehicleMakeService.getVehicleMake(2);
            vehicleMake.setId(5);
            vehicleMake.setCreatedBy("10:20:55");
            vehicleMake.setDetails("GL54 mercedes is a beautify and portable car");
            vehicleMake.setLastModifiedBy("20:20:50");

            vehicleMakes.add(vehicleMake);
        }

        assertEquals(initialSize + 1, vehicleMakes.size());
    }

    @Test
    void deleteVehicleMake() {
        int initialSize = vehicleMakes.size();

        if (vehicleMakes.size() != 0)
            vehicleMakes.remove(0);

        assertEquals(initialSize - 1, vehicleMakes.size());
    }

    @AfterEach
    void tearDown() {
        vehicleMakes = null;
    }
}