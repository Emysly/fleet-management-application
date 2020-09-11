package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.VehicleMaintenance;
import com.emysilva.fleet.management.application.repository.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMaintenanceService {
    @Autowired
    private VehicleMaintenanceRepository vehicleMaintenanceRepository;

    public List<VehicleMaintenance> getVehicleMaintenances() {
        return vehicleMaintenanceRepository.findAll();
    }

    public void addVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    public VehicleMaintenance getVehicleMaintenance(int id) {
        return vehicleMaintenanceRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle maintenance with id: " + id + "not found"));
    }

    public void deleteVehicleMaintenance(int id) {
        VehicleMaintenance vehicleMaintenanceToDelete = vehicleMaintenanceRepository.findById(id).orElseThrow(() -> new NoSuchDataException("vehicle maintenance with id: " + id + "not found"));
        vehicleMaintenanceRepository.delete(vehicleMaintenanceToDelete);
    }
}
