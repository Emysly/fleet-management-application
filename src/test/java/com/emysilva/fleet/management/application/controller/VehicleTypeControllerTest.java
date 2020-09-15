package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.VehicleType;
import com.emysilva.fleet.management.application.service.VehicleTypeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleTypeControllerTest {

    @Autowired
    private VehicleTypeService vehicleTypeService;


    List<VehicleType> vehicleTypes = null;

    @BeforeEach
    void setUp() {
        vehicleTypes = vehicleTypeService.getVehicleTypes();
    }

    @Test
    void getVehicleTypes() {
        assertEquals(vehicleTypes.size(), vehicleTypes.size());
    }

    @Test
    void getVehicleType() {
        if (vehicleTypes.size() > 0)
            assertEquals(vehicleTypeService.getVehicleType(2).getId(), vehicleTypeService.getVehicleType(2).getId());
    }

    @Test
    void addVehicleType() {
        VehicleType vehicleType = new VehicleType();
        vehicleType.setId(5);
        vehicleType.setDescription("GL54 mercedes is a beautify and portable car");

        int initialSize = vehicleTypes.size();

        vehicleTypes.add(vehicleType);

        assertEquals(initialSize + 1, vehicleTypes.size());
    }

    @Test
    void updateVehicleType() {
        int initialSize = vehicleTypes.size();
        if (vehicleTypes.size() > 0) {
            VehicleType vehicleType = vehicleTypeService.getVehicleType(2);
            vehicleType.setId(5);
            vehicleType.setDescription("GL54 mercedes is a beautify and portable car");

            vehicleTypes.add(vehicleType);

        }
        assertEquals(initialSize + 1, vehicleTypes.size());
    }

    @Test
    void deleteVehicleType() {
        int initialSize = vehicleTypes.size();

        if (vehicleTypes.size() > 0)
            vehicleTypes.remove(0);

        assertEquals(initialSize - 1, vehicleTypes.size());
    }

    @AfterEach
    void tearDown() {
        vehicleTypes = null;
    }
}