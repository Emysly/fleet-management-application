package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.Location;
import com.emysilva.fleet.management.application.model.Vehicle;
import com.emysilva.fleet.management.application.model.VehicleMovement;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.LocationService;
import com.emysilva.fleet.management.application.service.VehicleMovementService;
import com.emysilva.fleet.management.application.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class VehicleMovementController {

    @Autowired
    private VehicleMovementService vehicleMovementService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private LocationService locationService;


    @GetMapping("/vehicleMovements")
    public String getVehicleMovements(Model model) {
        List<VehicleMovement> vehicleMovements = vehicleMovementService.getVehicleMovements();
        List<Vehicle> vehicleServices = vehicleService.getVehicles();
        List<Location> locations = locationService.getLocations();
        model.addAttribute("vehicleMovements", vehicleMovements);
        model.addAttribute("vehicleServices", vehicleServices);
        model.addAttribute("locations", locations);
        return "vehiclemovement";
    }

    @GetMapping("/vehicleMovements/findById")
    @ResponseBody
    public VehicleMovement getVehicleMovement(int id) {
        return vehicleMovementService.getVehicleMovement(id);
    }

    @PostMapping("/vehicleMovements/addNew")
    public String addVehicleMovement(@Valid VehicleMovement vehicleMovement) {
        vehicleMovementService.addVehicleMovement(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value = "/vehicleMovements/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleMovement(@Valid VehicleMovement vehicleMovement) {
        vehicleMovementService.addVehicleMovement(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @GetMapping("/vehicleMovements/delete")
    public String deleteVehicleMovement(int id) {
        vehicleMovementService.deleteVehicleMovement(id);
        return "redirect:/vehicleMovements";
    }
}
