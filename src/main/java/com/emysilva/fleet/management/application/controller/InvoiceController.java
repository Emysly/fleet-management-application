package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.*;
import com.emysilva.fleet.management.application.service.ClientService;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.InvoiceService;
import com.emysilva.fleet.management.application.service.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/invoices")
    public String getInvoices(Model model) {
        List<Invoice> invoices = invoiceService.getInvoices();
        List<Client> clients = clientService.getClients();
        model.addAttribute("invoices", invoices);
        model.addAttribute("clients", clients);
        return "invoice";
    }

    @GetMapping("/invoices/findById")
    @ResponseBody
    public Invoice getInvoice(int id) {
        return invoiceService.getInvoice(id);
    }

    @PostMapping("/invoices/addNew")
    public String addInvoice(Invoice invoice) {
        invoiceService.addInvoice(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateInvoice(Invoice invoice) {
        invoiceService.addInvoice(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/invoices/delete")
    public String deleteInvoice(int id) {
        invoiceService.deleteInvoice(id);
        return "redirect:/invoices";
    }
}
