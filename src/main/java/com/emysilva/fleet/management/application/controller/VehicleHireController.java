package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Location;
import com.emysilva.fleet.management.application.model.Vehicle;
import com.emysilva.fleet.management.application.model.VehicleHire;
import com.emysilva.fleet.management.application.model.VehicleMovement;
import com.emysilva.fleet.management.application.service.LocationService;
import com.emysilva.fleet.management.application.service.VehicleHireService;
import com.emysilva.fleet.management.application.service.VehicleMovementService;
import com.emysilva.fleet.management.application.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class VehicleHireController {

    @Autowired
    private VehicleHireService vehicleHireService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private LocationService locationService;


    @GetMapping("/vehicleHires")
    public String getVehicleHires(Model model) {
        List<VehicleHire> vehicleHires = vehicleHireService.getVehicleHires();
        List<Vehicle> vehicleServices = vehicleService.getVehicles();
        List<Location> locations = locationService.getLocations();
        model.addAttribute("vehicleHires", vehicleHires);
        model.addAttribute("vehicleServices", vehicleServices);
        model.addAttribute("locations", locations);
        return "vehiclehire";
    }

    @GetMapping("/vehicleHires/findById")
    @ResponseBody
    public VehicleHire getVehicleHire(int id) {
        return vehicleHireService.getVehicleHire(id);
    }

    @PostMapping("/vehicleHires/addNew")
    public String addVehicleHire(@Valid VehicleHire vehicleHire) {
        vehicleHireService.addVehicleHire(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping(value = "/vehicleHires/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleHire(@Valid VehicleHire vehicleHire) {
        vehicleHireService.addVehicleHire(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @GetMapping("/vehicleHires/delete")
    public String deleteVehicleHire(int id) {
        vehicleHireService.deleteVehicleHire(id);
        return "redirect:/vehicleHires";
    }
}
