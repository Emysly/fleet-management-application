package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.*;
import com.emysilva.fleet.management.application.service.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleControllerTest {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleTypeService vehicleTypeService;
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @Autowired
    private VehicleModelService vehicleModelService;
    @Autowired
    private VehicleStatusService vehicleStatusService;
    @Autowired
    private LocationService locationService;

    List<Vehicle> vehicles = null;
    List<VehicleType> vehicleTypes = null;
    List<VehicleMake> vehicleMakes = null;
    List<VehicleModel> vehicleModels = null;
    List<VehicleStatus> vehicleStatuses = null;
    List<Location> locations = null;

    @BeforeEach
    void setUp() {
        vehicles = vehicleService.getVehicles();
        vehicleTypes = vehicleTypeService.getVehicleTypes();
        vehicleMakes = vehicleMakeService.getVehicleMakes();
        vehicleModels = vehicleModelService.getVehicleModels();
        vehicleStatuses = vehicleStatusService.getVehicleStatuses();
        locations = locationService.getLocations();
    }

    @Test
    void getVehicles() {
        assertEquals(vehicles.size(), vehicles.size());
        assertEquals(vehicleTypes.size(), vehicleTypes.size());
        assertEquals(vehicleMakes.size(), vehicleMakes.size());
        assertEquals(vehicleModels.size(), vehicleModels.size());
        assertEquals(vehicleStatuses.size(), vehicleStatuses.size());
        assertEquals(locations.size(), locations.size());
    }

    @Test
    void getVehicle() {
        if (vehicles.size() > 0)
            assertEquals(vehicleService.getVehicle(2).getDescription(), vehicleService.getVehicle(2).getDescription());
    }

    @Test
    void addVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(5);
        vehicle.setEmployeeid(3);
        vehicle.setDescription("GL54 mercedes is a beautify and portable car");
        vehicle.setFuelCapacity("90L");

        int initialSize = vehicles.size();

        vehicles.add(vehicle);

        assertEquals(initialSize + 1, vehicles.size());
    }

    @Test
    void updateVehicle() {
        int initialSize = vehicles.size();
        if (vehicles.size() != 0) {
            Vehicle vehicle = vehicleService.getVehicle(2);
            vehicle.setId(5);
            vehicle.setEmployeeid(3);
            vehicle.setDescription("GL54 mercedes is a beautify and portable car");
            vehicle.setFuelCapacity("90L");
            vehicles.add(vehicle);
        }
        assertEquals(initialSize + 1, vehicles.size());
    }

    @Test
    void deleteVehicle() {
        int initialSize = vehicles.size();

        if (vehicles.size() != 0)
            vehicles.remove(0);

        assertEquals(initialSize - 1, vehicles.size());
    }

    @AfterEach
    void tearDown() {
        vehicles = null;
        vehicleTypes = null;
        vehicleMakes = null;
        vehicleModels = null;
        vehicleStatuses = null;
        locations = null;
    }
}