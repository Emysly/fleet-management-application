package com.emysilva.fleet.management.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleTypeController {
    @GetMapping("/vehicleTypes")
    public String getVehicleTypes() {
        return "vehicletype";
    }
}
