package com.anshul.inventory.repo;

import com.anshul.inventory.dto.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends MongoRepository<Inventory, String> {
}
