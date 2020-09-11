package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.VehicleType;
import com.emysilva.fleet.management.application.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    public void addVehicleType(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    public VehicleType getVehicleType(int id) {
        return vehicleTypeRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle type with id: " + id + "not found"));
    }

    public void deleteVehicleType(int id) {
        VehicleType vehicleTypeToDelete = vehicleTypeRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle type with id: " + id + "not found"));
        vehicleTypeRepository.delete(vehicleTypeToDelete);
    }
}
