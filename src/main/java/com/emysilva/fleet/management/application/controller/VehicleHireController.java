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
public class VehicleHireController {

    @Autowired
    private VehicleHireService vehicleHireService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private ClientService clientService;


    @GetMapping("/vehicleHires")
    public String getVehicleHires(Model model) {
        List<VehicleHire> vehicleHires = vehicleHireService.getVehicleHires();
        List<Vehicle> vehicleServices = vehicleService.getVehicles();
        List<Location> locations = locationService.getLocations();
        List<Client> clients = clientService.getClients();
        model.addAttribute("vehicleHires", vehicleHires);
        model.addAttribute("vehicleServices", vehicleServices);
        model.addAttribute("locations", locations);
        model.addAttribute("clients", clients);
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
