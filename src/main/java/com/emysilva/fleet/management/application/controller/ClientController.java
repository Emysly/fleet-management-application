package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.State;
import com.emysilva.fleet.management.application.service.ClientService;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    @GetMapping("/clients")
    public String getClients(Model model) {
        List<Client> clients = clientService.getClients();
        List<Country> countries = countryService.getCountries();
        List<State> states = stateService.getStates();
        model.addAttribute("clients", clients);
        model.addAttribute("countries", countries);
        model.addAttribute("states", states);
        return "client";
    }

    @GetMapping("/clients/findById")
    @ResponseBody
    public Client getClient(int id) {
        return clientService.getClient(id);
    }

    @PostMapping("/clients/addNew")
    public String addClient(Client client) {
        clientService.addClient(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateClient(Client client) {
        clientService.addClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/clients/delete")
    public String deleteClient(int id) {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }
}
