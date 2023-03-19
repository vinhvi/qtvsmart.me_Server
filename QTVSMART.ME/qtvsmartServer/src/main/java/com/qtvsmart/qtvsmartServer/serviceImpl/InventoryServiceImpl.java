package com.qtvsmart.qtvsmartServer.serviceImpl;

import com.qtvsmart.qtvsmartServer.entity.Inventory;
import com.qtvsmart.qtvsmartServer.repository.InventoryRepository;
import com.qtvsmart.qtvsmartServer.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void addInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getById(int id) {
        Inventory inventory = getOneInventory(inventoryRepository.findInventoryById(id));
        return inventory;
    }

    @Override
    public Inventory getOneInventory(Inventory inventory) {
        Inventory inventory1 = new Inventory();
        inventory1.setId(inventory.getId());
        inventory1.setName(inventory.getName());
        inventory1.setAddress(inventory.getAddress());
        return inventory1;
    }
}
