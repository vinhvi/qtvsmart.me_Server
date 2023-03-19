package com.qtvsmart.qtvsmartServer.service;

import com.qtvsmart.qtvsmartServer.entity.Inventory;

public interface InventoryService  {
    void addInventory(Inventory inventory);

    Inventory getById(int id);

    Inventory getOneInventory(Inventory inventory);

}
