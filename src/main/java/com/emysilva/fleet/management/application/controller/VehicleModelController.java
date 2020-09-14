package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.Vehicle;
import com.emysilva.fleet.management.application.model.VehicleModel;
import com.emysilva.fleet.management.application.repository.VehicleModelRepository;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;


    @GetMapping("/vehicleModels")
    public String getVehicleModels(Model model) {
        List<VehicleModel> vehicleModels = vehicleModelService.getVehicleModels();
        model.addAttribute("vehicleModels", vehicleModels);
        return "vehiclemodel";
    }

    @GetMapping("/vehicleModels/findById")
    @ResponseBody
    public VehicleModel getVehicleModel(int id) {
        return vehicleModelService.getVehicleModel(id);
    }

    @PostMapping("/vehicleModels/addNew")
    public String addVehicleModel(@Valid VehicleModel vehicleModel) {
        vehicleModelService.addVehicleModel(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @RequestMapping(value = "/vehicleModels/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateVehicleModel(@Valid VehicleModel vehicleModel) {
        vehicleModelService.addVehicleModel(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @GetMapping("/vehicleModels/delete")
    public String deleteVehicleModel(int id) {
        vehicleModelService.deleteVehicleModel(id);
        return "redirect:/vehicleModels";
    }
}
