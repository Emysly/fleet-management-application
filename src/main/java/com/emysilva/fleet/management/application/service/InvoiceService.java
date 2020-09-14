package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Invoice;
import com.emysilva.fleet.management.application.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    public void addInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public Invoice getInvoice(int id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new NoSuchDataException("invoice with id: " + id + "not found"));
    }

    public void deleteInvoice(int id) {
        Invoice invoiceToDelete = invoiceRepository.findById(id).orElseThrow(() -> new NoSuchDataException("invoice with id: " + id + "not found"));
        invoiceRepository.delete(invoiceToDelete);
    }
}
