package Practice.QuickCommerce.Service;

import Practice.QuickCommerce.Models.Inventory;
import Practice.QuickCommerce.Repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory addProduct(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    public Integer getStock(Long productId){
        return inventoryRepository.getStock(productId);
    }

    public Inventory updateStock(Long productId, Integer quantity){
        inventoryRepository.updateStock(productId,quantity);
        return inventoryRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Inventory> getAllInventory(){
        return inventoryRepository.getAll();
    }
}
