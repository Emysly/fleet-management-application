package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.VehicleMake;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;


    @GetMapping("/vehicleMakes")
    public String getVehicleMakes(Model model) {
        List<VehicleMake> vehicleMakes = vehicleMakeService.getVehicleMakes();
        model.addAttribute("vehicleMakes", vehicleMakes);
        return "vehiclemake";
    }

    @GetMapping("/vehicleMakes/findById")
    @ResponseBody
    public VehicleMake getVehicleMake(int id) {
        return vehicleMakeService.getVehicleMake(id);
    }

    @PostMapping("/vehicleMakes/addNew")
    public String addVehicleMake(@Valid VehicleMake vehicleMake) {
        vehicleMakeService.addVehicleMake(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping(value = "/vehicleMakes/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleMake(@Valid VehicleMake vehicleMake) {
        vehicleMakeService.addVehicleMake(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @GetMapping("/vehicleMakes/delete")
    public String deleteVehicleMake(int id) {
        vehicleMakeService.deleteVehicleMake(id);
        return "redirect:/vehicleMakes";
    }
}
