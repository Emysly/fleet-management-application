package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.Vehicle;
import com.emysilva.fleet.management.application.repository.ClientRepository;
import com.emysilva.fleet.management.application.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicle(int id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle with id: " + id + "not found"));
    }

    public void deleteVehicle(int id) {
        Vehicle vehicleToDelete = vehicleRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle with id: " + id + "not found"));
        vehicleRepository.delete(vehicleToDelete);
    }
}
