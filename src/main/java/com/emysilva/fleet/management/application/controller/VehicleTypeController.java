package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.VehicleType;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.VehicleStatusService;
import com.emysilva.fleet.management.application.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;


    @GetMapping("/vehicleTypes")
    public String getVehicleTypes(Model model) {
        List<VehicleType> vehicleTypes = vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicleTypes", vehicleTypes);
        return "vehicletype";
    }

    @GetMapping("/vehicleTypes/findById")
    @ResponseBody
    public VehicleType getVehicleType(int id) {
        return vehicleTypeService.getVehicleType(id);
    }

    @PostMapping("/vehicleTypes/addNew")
    public String addVehicleType(@Valid VehicleType vehicleType) {
        vehicleTypeService.addVehicleType(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value = "/vehicleTypes/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleType(@Valid VehicleType vehicleType) {
        vehicleTypeService.addVehicleType(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @GetMapping("/vehicleTypes/delete")
    public String deleteVehicleType(int id) {
        vehicleTypeService.deleteVehicleType(id);
        return "redirect:/vehicleTypes";
    }
}
