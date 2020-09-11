package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.Invoice;
import com.emysilva.fleet.management.application.model.InvoiceStatus;
import com.emysilva.fleet.management.application.service.ClientService;
import com.emysilva.fleet.management.application.service.InvoiceService;
import com.emysilva.fleet.management.application.service.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String getClients(Model model) {
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
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
