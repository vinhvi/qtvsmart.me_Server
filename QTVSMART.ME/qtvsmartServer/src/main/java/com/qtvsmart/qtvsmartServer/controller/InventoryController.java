package com.qtvsmart.qtvsmartServer.controller;

import com.qtvsmart.qtvsmartServer.entity.Inventory;
import com.qtvsmart.qtvsmartServer.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public String addInventory(@RequestBody Inventory inventory) {
        inventoryService.addInventory(inventory);
        return "success";
    }
}
