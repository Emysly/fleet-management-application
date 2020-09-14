package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.InvoiceStatus;
import com.emysilva.fleet.management.application.repository.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    public List<InvoiceStatus> getInvoiceStatuses() {
        return invoiceStatusRepository.findAll();
    }

    public void addInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    public InvoiceStatus getInvoiceStatus(int id) {
        return invoiceStatusRepository.findById(id).orElseThrow(() -> new NoSuchDataException("invoice status with id: " + id + "not found"));
    }

    public void deleteInvoiceStatus(int id) {
        InvoiceStatus invoiceStatusToDelete = invoiceStatusRepository.findById(id).orElseThrow(() -> new NoSuchDataException("invoice status with id: " + id + "not found"));
        invoiceStatusRepository.delete(invoiceStatusToDelete);
    }
}
