package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.VehicleMovement;
import com.emysilva.fleet.management.application.repository.ClientRepository;
import com.emysilva.fleet.management.application.repository.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMovementService {
    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;

    public List<VehicleMovement> getVehicleMovements() {
        return vehicleMovementRepository.findAll();
    }

    public void addVehicleMovement(VehicleMovement vehicleMovement) {
        vehicleMovementRepository.save(vehicleMovement);
    }

    public VehicleMovement getVehicleMovement(int id) {
        return vehicleMovementRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle movement with id: " + id + "not found"));
    }

    public void deleteVehicleMovement(int id) {
        VehicleMovement vehicleMovementToDelete = vehicleMovementRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle movement with id: " + id + "not found"));
        vehicleMovementRepository.delete(vehicleMovementToDelete);
    }
}
