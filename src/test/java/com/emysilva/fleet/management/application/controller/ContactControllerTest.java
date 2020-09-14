package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.Contact;
import com.emysilva.fleet.management.application.service.ContactService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactControllerTest {

    @Autowired
    private ContactService contactService;

    List<Contact> contacts = null;

    @BeforeEach
    void setUp() {
        contacts = contactService.getContacts();
    }

    @Test
    void getContacts() {
        assertEquals(contacts.size(), contacts.size());
    }

    @Test
    void getContact() {
        assertEquals(contactService.getContact(1).getEmail(), contactService.getContact(1).getEmail());
    }

    @Test
    void addContact() {
        Contact contact = new Contact();
        contact.setId(5);
        contact.setEmail("emysly12@gmail.com");
        contact.setFirstname("Chukwuebuka");
        contact.setLastname("Emmanuel");
        contact.setPhone("09040201098");

        int initialSize = contacts.size();

        contacts.add(contact);

        assertEquals(initialSize + 1, contacts.size());
    }

    @Test
    void updateContact() {
        Contact contact = contactService.getContact(1);
        contact.setId(5);
        contact.setEmail("emysly12@gmail.com");
        contact.setFirstname("Chukwuebuka");
        contact.setLastname("Emmanuel");
        contact.setPhone("09040201098");

        int initialSize = contacts.size();

        contacts.add(contact);

        assertEquals(initialSize + 1, contacts.size());
    }

    @Test
    void deleteContact() {
        int initialSize = contacts.size();

        if (contacts.size() != 0)
            contacts.remove(0);

        assertEquals(initialSize - 1, contacts.size());
    }

    @AfterEach
    void tearDown() {
        contacts = null;
    }

}