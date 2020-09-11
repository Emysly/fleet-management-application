package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;


    @GetMapping("/countries")
    public String getCountries(Model model) {
        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);
        return "country";
    }

    @GetMapping("/countries/findById")
    @ResponseBody
    public Country getCountry(int id) {
        return countryService.getCountry(id);
    }

    @PostMapping("/countries/addNew")
    public String addCountry(@Valid Country country) {
        countryService.addCountry(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateCountry(@Valid Country country) {
        countryService.addCountry(country);
        return "redirect:/countries";
    }

    @GetMapping("/countries/delete")
    public String deleteCountry(int id) {
        countryService.deleteCountry(id);
        return "redirect:/countries";
    }
}
