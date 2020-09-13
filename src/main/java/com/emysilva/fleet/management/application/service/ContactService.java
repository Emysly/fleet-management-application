package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.Contact;
import com.emysilva.fleet.management.application.repository.ClientRepository;
import com.emysilva.fleet.management.application.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    public Contact getContact(int id) {
        return contactRepository.findById(id).orElseThrow(() -> new NoSuchDataException("contact with id: " + id + "not found"));
    }

    public void deleteContact(int id) {
        Contact contactToDelete = contactRepository.findById(id).orElseThrow(() -> new NoSuchDataException("contact with id: " + id + "not found"));
        contactRepository.delete(contactToDelete);
    }
}
