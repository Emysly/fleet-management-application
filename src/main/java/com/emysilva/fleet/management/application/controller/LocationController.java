package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.Location;
import com.emysilva.fleet.management.application.model.State;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.LocationService;
import com.emysilva.fleet.management.application.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/locations")
    public String getLocations(Model model) {
        List<Location> locations = locationService.getLocations();
        List<State> states = stateService.getStates();
        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);
        model.addAttribute("states", states);
        model.addAttribute("locations", locations);
        return "location";
    }

    @GetMapping("/locations/findById")
    @ResponseBody
    public Location getLocation(int id) {
        return locationService.getLocation(id);
    }

    @PostMapping("/locations/addNew")
    public String addLocation(Location location) {
        locationService.addLocation(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateLocation(Location location) {
        locationService.addLocation(location);
        return "redirect:/locations";
    }

    @GetMapping("/locations/delete")
    public String deleteLocation(int id) {
        locationService.deleteLocation(id);
        return "redirect:/locations";
    }
}
