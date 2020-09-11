package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.Vehicle;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.VehicleService;
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


    @GetMapping("/vehicles")
    public String getVehicles(Model model) {
        List<Vehicle> vehicles = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicles);
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
