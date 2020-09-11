package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.*;
import com.emysilva.fleet.management.application.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class VehicleController {

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



    @GetMapping("/vehicles")
    public String getVehicles(Model model) {
        List<Vehicle> vehicles = vehicleService.getVehicles();
        List<VehicleType> vehicleTypes = vehicleTypeService.getVehicleTypes();
        List<VehicleMake> vehicleMakes = vehicleMakeService.getVehicleMakes();
        List<VehicleModel> vehicleModels = vehicleModelService.getVehicleModels();
        List<Location> locations = locationService.getLocations();
        List<VehicleStatus> vehicleStatuses = vehicleStatusService.getVehicleStatuses();
        model.addAttribute("vehicles", vehicles);
        model.addAttribute("vehicleTypes", vehicleTypes);
        model.addAttribute("vehicleMakes", vehicleMakes);
        model.addAttribute("vehicleModels", vehicleModels);
        model.addAttribute("vehicleStatuses", vehicleStatuses);
        model.addAttribute("locations", locations);
        return "vehicle";
    }

    @GetMapping("/vehicles/findById")
    @ResponseBody
    public Vehicle getVehicle(int id) {
        return vehicleService.getVehicle(id);
    }

    @PostMapping("/vehicles/addNew")
    public String addVehicle(@Valid Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/vehicles/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicle(@Valid Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/vehicles/delete")
    public String deleteVehicle(int id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles";
    }
}
