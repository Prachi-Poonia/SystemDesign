package Practice.QuickCommerce.Controller;

import Practice.QuickCommerce.Models.Order;
import Practice.QuickCommerce.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.getOrder(order));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId){
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @PatchMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestParam String status){
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId,status));
    }

    @PostMapping("/{orderId}/cancel")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long orderId){
        return ResponseEntity.ok(orderService.cancelOrder(orderId));
    }
}
