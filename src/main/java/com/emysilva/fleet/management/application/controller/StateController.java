package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.State;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StateController {

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/states")
    public String getStates(Model model) {
        List<State> states = stateService.getStates();
        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);
        model.addAttribute("states", states);
        return "state";
    }

    @GetMapping("/states/findById")
    @ResponseBody
    public State getState(int id) {
        return stateService.getState(id);
    }

    @PostMapping("/states/addNew")
    public String addState(State state) {
        stateService.addState(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateState(State state) {
        stateService.addState(state);
        return "redirect:/states";
    }

    @GetMapping("/states/delete")
    public String deleteState(int id) {
        stateService.deleteState(id);
        return "redirect:/states";
    }
}
