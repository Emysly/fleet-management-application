package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.VehicleModel;
import com.emysilva.fleet.management.application.repository.ClientRepository;
import com.emysilva.fleet.management.application.repository.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    public List<VehicleModel> getVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    public void addVehicleModel(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    public VehicleModel getVehicleModel(int id) {
        return vehicleModelRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle model with id: " + id + "not found"));
    }

    public void deleteVehicleModel(int id) {
        VehicleModel vehicleModelToDelete = vehicleModelRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle model with id: " + id + "not found"));
        vehicleModelRepository.delete(vehicleModelToDelete);
    }
}
