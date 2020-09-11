package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.VehicleStatus;
import com.emysilva.fleet.management.application.repository.ClientRepository;
import com.emysilva.fleet.management.application.repository.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleStatusService {
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    public List<VehicleStatus> getVehicleStatuses() {
        return vehicleStatusRepository.findAll();
    }

    public void addVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    public VehicleStatus getVehicleStatus(int id) {
        return vehicleStatusRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle status with id: " + id + "not found"));
    }

    public void deleteVehicleStatus(int id) {
        VehicleStatus vehicleStatusToDelete = vehicleStatusRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle status with id: " + id + "not found"));
        vehicleStatusRepository.delete(vehicleStatusToDelete);
    }
}
