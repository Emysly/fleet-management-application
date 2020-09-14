package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.Supplier;
import com.emysilva.fleet.management.application.repository.ClientRepository;
import com.emysilva.fleet.management.application.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public void addSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public Supplier getSupplier(int id) {
        return supplierRepository.findById(id).orElseThrow(() -> new NoSuchDataException("supplier with id: " + id + "not found"));
    }

    public void deleteSupplier(int id) {
        Supplier supplierToDelete = supplierRepository.findById(id).orElseThrow(() -> new NoSuchDataException("supplier with id: " + id + "not found"));
        supplierRepository.delete(supplierToDelete);
    }
}
