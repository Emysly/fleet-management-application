package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Contact;
import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.VehicleType;
import com.emysilva.fleet.management.application.service.ContactService;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;


    @GetMapping("/contacts")
    public String getContacts(Model model) {
        List<Contact> contacts = contactService.getContacts();
        model.addAttribute("contacts", contacts);
        return "contact";
    }

    @GetMapping("/contacts/findById")
    @ResponseBody
    public Contact getContact(int id) {
        return contactService.getContact(id);
    }

    @PostMapping("/contacts/addNew")
    public String addContact(@Valid Contact contact) {
        contactService.addContact(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateContact(@Valid Contact contact) {
        contactService.addContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/contacts/delete")
    public String deleteContact(int id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }
}
