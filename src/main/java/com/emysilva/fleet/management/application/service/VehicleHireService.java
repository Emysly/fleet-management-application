package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.VehicleHire;
import com.emysilva.fleet.management.application.repository.ClientRepository;
import com.emysilva.fleet.management.application.repository.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleHireService {
    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    public List<VehicleHire> getVehicleHires() {
        return vehicleHireRepository.findAll();
    }

    public void addVehicleHire(VehicleHire vehicleHire) {
        vehicleHireRepository.save(vehicleHire);
    }

    public VehicleHire getVehicleHire(int id) {
        return vehicleHireRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle hire with id: " + id + "not found"));
    }

    public void deleteClient(int id) {
        VehicleHire vehicleHireToDelete = vehicleHireRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle hire with id: " + id + "not found"));
        vehicleHireRepository.delete(vehicleHireToDelete);
    }
}
