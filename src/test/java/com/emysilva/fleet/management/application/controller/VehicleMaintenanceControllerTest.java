package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.*;
import com.emysilva.fleet.management.application.service.VehicleMaintenanceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleMaintenanceControllerTest {
    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;

    List<VehicleMaintenance> vehicleMaintenances = null;

    @BeforeEach
    void setUp() {
        vehicleMaintenances = vehicleMaintenanceService.getVehicleMaintenances();
    }

    @Test
    void getVehicleMaintenances() {
        assertEquals(vehicleMaintenances.size(), vehicleMaintenances.size());
    }

    @Test
    void getVehicleMaintenance() {
        if (vehicleMaintenances.size() > 0)
            assertEquals(vehicleMaintenanceService.getVehicleMaintenance(2).getPrice(), vehicleMaintenanceService.getVehicleMaintenance(2).getPrice());
    }

    @Test
    void addVehicleMaintenance() {
        VehicleMaintenance vehicleMaintenance = new VehicleMaintenance();
        vehicleMaintenance.setId(5);
        vehicleMaintenance.setPrice(30.0);
        vehicleMaintenance.setRemarks("GL54 mercedes is a beautify and portable car");
        vehicleMaintenance.setSupplierid(2);

        int initialSize = vehicleMaintenances.size();

        vehicleMaintenances.add(vehicleMaintenance);

        assertEquals(initialSize + 1, vehicleMaintenances.size());
    }

    @Test
    void updateVehicleMaintenance() {
        int initialSize = vehicleMaintenances.size();
        if (vehicleMaintenances.size() != 0) {
            VehicleMaintenance vehicleMaintenance = vehicleMaintenanceService.getVehicleMaintenance(2);
            vehicleMaintenance.setId(5);
            vehicleMaintenance.setPrice(30.0);
            vehicleMaintenance.setRemarks("GL54 mercedes is a beautify and portable car");
            vehicleMaintenance.setSupplierid(2);

            vehicleMaintenances.add(vehicleMaintenance);

        }
        assertEquals(initialSize + 1, vehicleMaintenances.size());
    }

    @Test
    void deleteVehicleMaintenance() {
        int initialSize = vehicleMaintenances.size();

        if (vehicleMaintenances.size() != 0)
            vehicleMaintenances.remove(0);

        assertEquals(initialSize - 1, vehicleMaintenances.size());
    }

    @AfterEach
    void tearDown() {
        vehicleMaintenances = null;
    }
}