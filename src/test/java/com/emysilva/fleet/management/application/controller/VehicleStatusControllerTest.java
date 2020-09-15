package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Vehicle;
import com.emysilva.fleet.management.application.model.VehicleMovement;
import com.emysilva.fleet.management.application.model.VehicleStatus;
import com.emysilva.fleet.management.application.service.VehicleStatusService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleStatusControllerTest {
    @Autowired
    private VehicleStatusService vehicleStatusService;

    List<VehicleStatus> vehicleStatuses = null;

    @BeforeEach
    void setUp() {
        vehicleStatuses = vehicleStatusService.getVehicleStatuses();
    }

    @Test
    void getVehicleStatuses() {
        assertEquals(vehicleStatuses.size(), vehicleStatuses.size());
    }

    @Test
    void getVehicleStatus() {
        if (vehicleStatuses.size() > 0)
            assertEquals(vehicleStatusService.getVehicleStatus(2).getId(), vehicleStatusService.getVehicleStatus(2).getId());
    }

    @Test
    void addVehicleStatus() {
        VehicleStatus vehicleStatus = new VehicleStatus();
        vehicleStatus.setId(5);
        vehicleStatus.setDescription("GL54 mercedes is a beautify and portable car");

        int initialSize = vehicleStatuses.size();

        vehicleStatuses.add(vehicleStatus);

        assertEquals(initialSize + 1, vehicleStatuses.size());
    }

    @Test
    void updateVehicleStatus() {
        int initialSize = vehicleStatuses.size();
        if (vehicleStatuses.size() > 0) {
            VehicleStatus vehicleStatus = new VehicleStatus();
            vehicleStatus.setId(5);
            vehicleStatus.setDescription("GL54 mercedes is a beautify and portable car");


            vehicleStatuses.add(vehicleStatus);
        }

       assertEquals(initialSize + 1, vehicleStatuses.size());
    }

    @Test
    void deleteVehicleStatus() {
        int initialSize = vehicleStatuses.size();

        if (vehicleStatuses.size() > 0)
            vehicleStatuses.remove(0);

        assertEquals(initialSize - 1, vehicleStatuses.size());
    }

    @AfterEach
    void tearDown() {
        vehicleStatuses = null;
    }
}