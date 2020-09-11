package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.VehicleStatus;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;


    @GetMapping("/vehicleStatuses")
    public String getVehicleStatuses(Model model) {
        List<VehicleStatus> vehicleStatuses = vehicleStatusService.getVehicleStatuses();
        model.addAttribute("vehicleStatuses", vehicleStatuses);
        return "vehiclestatus";
    }

    @GetMapping("/vehicleStatuses/findById")
    @ResponseBody
    public VehicleStatus getVehicleStatus(int id) {
        return vehicleStatusService.getVehicleStatus(id);
    }

    @PostMapping("/vehicleStatuses/addNew")
    public String addVehicleStatus(@Valid VehicleStatus vehicleStatus) {
        vehicleStatusService.addVehicleStatus(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping(value = "/vehicleStatuses/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleStatus(@Valid VehicleStatus vehicleStatus) {
        vehicleStatusService.addVehicleStatus(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @GetMapping("/vehicleStatuses/delete")
    public String deleteVehicleStatus(int id) {
        vehicleStatusService.deleteVehicleStatus(id);
        return "redirect:/vehicleStatuses";
    }
}
