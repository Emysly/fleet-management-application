package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.Invoice;
import com.emysilva.fleet.management.application.repository.ClientRepository;
import com.emysilva.fleet.management.application.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public Client getClient(int id) {
        return clientRepository.findById(id).orElseThrow(() -> new NoSuchDataException("client with id: " + id + "not found"));
    }

    public void deleteClient(int id) {
        Client clientToDelete = clientRepository.findById(id).orElseThrow(() -> new NoSuchDataException("client with id: " + id + "not found"));
        clientRepository.delete(clientToDelete);
    }
}
