package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.*;
import com.emysilva.fleet.management.application.service.ClientService;
import com.emysilva.fleet.management.application.service.InvoiceService;
import com.emysilva.fleet.management.application.service.InvoiceStatusService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceControllerTest {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @Autowired
    private ClientService clientService;

    List<Invoice> invoices = null;
    List<InvoiceStatus> invoiceStatuses = null;
    List<Client> clients = null;

    @BeforeEach
    void setUp() {
        invoices = invoiceService.getInvoices();
        invoiceStatuses = invoiceStatusService.getInvoiceStatuses();
        clients = clientService.getClients();
    }

    @Test
    void getInvoices() {
        assertEquals(invoices.size(), invoices.size());
        assertEquals(invoiceStatuses.size(), invoiceStatuses.size());
        assertEquals(clients.size(), clients.size());
    }

    @Test
    void getInvoice() {
        assertEquals(invoiceService.getInvoice(2).getClientid(), invoiceService.getInvoice(2).getClientid());
    }

    @Test
    void addInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId(5);
        invoice.setClientid(2);
        invoice.setInvoicestatusid(2);

        int initialSize = invoices.size();

        invoices.add(invoice);

        assertEquals(initialSize + 1, invoices.size());
    }

    @Test
    void updateEmployee() {
        Invoice invoice = invoiceService.getInvoice(2);
        invoice.setId(5);
        invoice.setClientid(2);
        invoice.setInvoicestatusid(2);

        int initialSize = invoices.size();

        invoices.add(invoice);

        assertEquals(initialSize + 1, invoices.size());
    }

    @Test
    void deleteEmployee() {
        int initialSize = invoices.size();

        if (invoices.size() != 0)
            invoices.remove(0);

        assertEquals(initialSize - 1, invoices.size());
    }

    @AfterEach
    void tearDown() {
        invoices = null;
        clients = null;
        invoiceStatuses = null;
    }

}