package Practice.QuickCommerce.Controller;

import Practice.QuickCommerce.Models.Inventory;
import Practice.QuickCommerce.Service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @PatchMapping("/{productId}/updateStock")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Long productId, @RequestParam Integer quantity){
        return ResponseEntity.ok(inventoryService.updateStock(productId,quantity));
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Inventory> allProductToInventory(@RequestBody Inventory inventory){
        return ResponseEntity.ok(inventoryService.addProduct(inventory));
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory(){
        return ResponseEntity.ok(inventoryService.getAllInventory());
    }
}
