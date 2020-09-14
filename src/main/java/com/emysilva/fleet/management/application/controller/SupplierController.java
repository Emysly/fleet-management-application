package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.State;
import com.emysilva.fleet.management.application.model.Supplier;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.StateService;
import com.emysilva.fleet.management.application.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;


    @GetMapping("/suppliers")
    public String getSuppliers(Model model) {
        List<Supplier> suppliers = supplierService.getSuppliers();
        List<Country> countries = countryService.getCountries();
        List<State> states = stateService.getStates();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("countries", countries);
        model.addAttribute("states", states);
        return "supplier";
    }

    @GetMapping("/suppliers/findById")
    @ResponseBody
    public Supplier getSupplier(int id) {
        return supplierService.getSupplier(id);
    }

    @PostMapping("/suppliers/addNew")
    public String addSupplier(@Valid Supplier supplier) {
        supplierService.addSupplier(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/suppliers/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateSupplier(@Valid Supplier supplier) {
        supplierService.addSupplier(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/suppliers/delete")
    public String deleteSupplier(int id) {
        supplierService.deleteSupplier(id);
        return "redirect:/suppliers";
    }
}
