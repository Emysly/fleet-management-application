package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.VehicleMaintenance;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.VehicleMaintenanceService;
import com.emysilva.fleet.management.application.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class VehicleMaintenanceController {

    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;


    @GetMapping("/vehicleMaintenances")
    public String getVehicleMaintenances(Model model) {
        List<VehicleMaintenance> vehicleMaintenances = vehicleMaintenanceService.getVehicleMaintenances();
        model.addAttribute("vehicleMaintenances", vehicleMaintenances);
        return "vehiclemaintenance";
    }

    @GetMapping("/vehicleMaintenances/findById")
    @ResponseBody
    public VehicleMaintenance getVehicleMaintenance(int id) {
        return vehicleMaintenanceService.getVehicleMaintenance(id);
    }

    @PostMapping("/vehicleMaintenances/addNew")
    public String addVehicleMaintenance(@Valid VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.addVehicleMaintenance(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping(value = "/vehicleMaintenances/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleMaintenance(@Valid VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.addVehicleMaintenance(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @GetMapping("/vehicleMaintenances/delete")
    public String deleteVehicleMaintenance(int id) {
        vehicleMaintenanceService.deleteVehicleMaintenance(id);
        return "redirect:/vehicleMaintenances";
    }
}
