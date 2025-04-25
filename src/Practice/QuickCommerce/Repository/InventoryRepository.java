package Practice.QuickCommerce.Repository;

import Practice.QuickCommerce.Models.Inventory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InventoryRepository {
    private final List<Inventory> inventoryList = new ArrayList<>();
    private Long productIdCounter = 1L;

    public Inventory save(Inventory inventory){
        if(inventory.getProductId() == null){
            inventory.setProductId(productIdCounter++);
        }
        inventoryList.add(inventory);
        return inventory;
    }

    public List<Inventory> getAll(){
        return new ArrayList<>(inventoryList);
    }
    public Optional<Inventory> findById(Long productId){
        return inventoryList.stream().filter(product -> product.getProductId().equals(productId)).findFirst();
    }

    public Integer getStock(Long productId){
        return findById(productId).map(Inventory::getStock).orElse(0);
    }

    public void updateStock(Long productId, Integer quantity){
        findById(productId).ifPresent(product -> product.setStock(product.getStock() + quantity));
    }
}
