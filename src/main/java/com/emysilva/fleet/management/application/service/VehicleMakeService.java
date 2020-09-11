package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.VehicleMake;
import com.emysilva.fleet.management.application.repository.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMakeService {
    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    public List<VehicleMake> getVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    public void addVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

    public VehicleMake getVehicleMake(int id) {
        return vehicleMakeRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle make with id: " + id + "not found"));
    }

    public void deleteVehicleMake(int id) {
        VehicleMake vehicleMakeToDelete = vehicleMakeRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle make with id: " + id + "not found"));
        vehicleMakeRepository.delete(vehicleMakeToDelete);
    }
}
