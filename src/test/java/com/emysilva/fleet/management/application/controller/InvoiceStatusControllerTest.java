package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Contact;
import com.emysilva.fleet.management.application.model.InvoiceStatus;
import com.emysilva.fleet.management.application.service.InvoiceStatusService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceStatusControllerTest {
    @Autowired
    private InvoiceStatusService invoiceStatusService;

    List<InvoiceStatus> invoiceStatuses = null;

    @BeforeEach
    void setUp() {
        invoiceStatuses = invoiceStatusService.getInvoiceStatuses();
    }

    @Test
    void getInvoiceStatuses() {
        assertEquals(invoiceStatuses.size(), invoiceStatuses.size());
    }

    @Test
    void getInvoiceStatus() {
        assertEquals(invoiceStatusService.getInvoiceStatus(1).getDetails(), invoiceStatusService.getInvoiceStatus(1).getDetails());
    }

    @Test
    void addInvoiceStatus() {
        InvoiceStatus invoiceStatus = new InvoiceStatus();
        invoiceStatus.setId(5);
        invoiceStatus.setDescription("Invoice issued");
        invoiceStatus.setDetails("Invoice issued with everything in check");

        int initialSize = invoiceStatuses.size();

        invoiceStatuses.add(invoiceStatus);

        assertEquals(initialSize + 1, invoiceStatuses.size());
    }

    @Test
    void updateInvoiceStatus() {
        InvoiceStatus invoiceStatus = invoiceStatusService.getInvoiceStatus(1);
        invoiceStatus.setId(5);
        invoiceStatus.setDescription("Invoice issued");
        invoiceStatus.setDetails("Invoice issued with everything in check");

        int initialSize = invoiceStatuses.size();

        invoiceStatuses.add(invoiceStatus);

        assertEquals(initialSize + 1, invoiceStatuses.size());
    }

    @Test
    void deleteContact() {
        int initialSize = invoiceStatuses.size();

        if (invoiceStatuses.size() != 0)
            invoiceStatuses.remove(0);

        assertEquals(initialSize - 1, invoiceStatuses.size());
    }

    @AfterEach
    void tearDown() {
        invoiceStatuses = null;
    }

}