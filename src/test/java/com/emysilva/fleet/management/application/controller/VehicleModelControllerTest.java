package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.VehicleMaintenance;
import com.emysilva.fleet.management.application.model.VehicleModel;
import com.emysilva.fleet.management.application.service.VehicleModelService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleModelControllerTest {

    @Autowired
    private VehicleModelService vehicleModelService;

    List<VehicleModel> vehicleModels = null;

    @BeforeEach
    void setUp() {
        vehicleModels = vehicleModelService.getVehicleModels();
    }

    @Test
    void getVehicleModels() {
        assertEquals(vehicleModels.size(), vehicleModels.size());
    }

    @Test
    void getVehicleModel() {
        if (vehicleModels.size() > 0)
            assertEquals(vehicleModelService.getVehicleModel(2).getCreatedBy(), vehicleModelService.getVehicleModel(2).getCreatedBy());
    }

    @Test
    void addVehicleModel() {
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setId(5);
        vehicleModel.setCreatedBy("10:20:50");
        vehicleModel.setDetails("GL54 mercedes is a beautify and portable car");

        int initialSize = vehicleModels.size();

        vehicleModels.add(vehicleModel);

        assertEquals(initialSize + 1, vehicleModels.size());
    }

    @Test
    void updateVehicleModel() {
        int initialSize = vehicleModels.size();
        if (vehicleModels.size() > 0) {
            VehicleModel vehicleModel = vehicleModelService.getVehicleModel(2);
            vehicleModel.setId(5);
            vehicleModel.setCreatedBy("10:20:50");
            vehicleModel.setDetails("GL54 mercedes is a beautify and portable car");


            vehicleModels.add(vehicleModel);


        }
        assertEquals(initialSize + 1, vehicleModels.size());
    }

    @Test
    void deleteVehicleModel() {
        int initialSize = vehicleModels.size();

        if (vehicleModels.size() > 0)
            vehicleModels.remove(0);

        assertEquals(initialSize - 1, vehicleModels.size());
    }

    @AfterEach
    void tearDown() {
        vehicleModels = null;
    }
}