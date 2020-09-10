package com.emysilva.fleet.management.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceController {
    @GetMapping("/invoices")
    public String getInvoice() {
        return "invoice";
    }
}
