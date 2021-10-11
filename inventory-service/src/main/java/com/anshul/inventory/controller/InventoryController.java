package com.anshul.inventory.controller;

import com.anshul.inventory.dto.Inventory;
import com.anshul.inventory.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class InventoryController {

    @Autowired
    private InventoryRepo repo;

    @RequestMapping(value = "/getInventory", method = RequestMethod.GET)
    public List<Inventory> getAllUsers() {
        return repo.findAll();
    }
}
