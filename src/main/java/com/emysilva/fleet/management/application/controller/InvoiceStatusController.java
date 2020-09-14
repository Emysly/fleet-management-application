package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Invoice;
import com.emysilva.fleet.management.application.model.InvoiceStatus;
import com.emysilva.fleet.management.application.service.InvoiceService;
import com.emysilva.fleet.management.application.service.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceStatusController {
    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoiceStatuses")
    public String getInvoiceStatuses(Model model) {
        List<InvoiceStatus> invoiceStatuses = invoiceStatusService.getInvoiceStatuses();
        model.addAttribute("invoiceStatuses", invoiceStatuses);
        return "invoicestatus";
    }

    @GetMapping("/invoiceStatuses/findById")
    @ResponseBody
    public InvoiceStatus getInvoiceStatus(int id) {
        return invoiceStatusService.getInvoiceStatus(id);
    }

    @PostMapping("/invoiceStatuses/addNew")
    public String addInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusService.addInvoiceStatus(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping(value = "/invoiceStatuses/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusService.addInvoiceStatus(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @GetMapping("/invoiceStatuses/delete")
    public String deleteInvoiceStatus(int id) {
        invoiceStatusService.deleteInvoiceStatus(id);
        return "redirect:/invoiceStatuses";
    }
}
