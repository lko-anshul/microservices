package com.anshul.inventory.controller;

import com.anshul.inventory.dto.Inventory;
import com.anshul.inventory.repo.InventoryRepo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepo repo;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getInventory", method = RequestMethod.GET)
    public List<Inventory> getAllInventory() {
        return repo.findAll();
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public String getUserInfo() {
        InstanceInfo service = eurekaClient
                .getApplication("user")
                .getInstances()
                .get(0);

        String url = "http://" + service.getHostName() + ":" + service.getPort() + "/user/getUserLogin";
        return restTemplate.getForObject(url, String.class);
    }
}
