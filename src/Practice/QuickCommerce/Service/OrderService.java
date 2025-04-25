package Practice.QuickCommerce.Service;

import Practice.QuickCommerce.Models.Order;
import Practice.QuickCommerce.Models.OrderItem;
import Practice.QuickCommerce.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryService inventoryService;

    public OrderService(OrderRepository orderRepository, InventoryService inventoryService) {
        this.orderRepository = orderRepository;
        this.inventoryService = inventoryService;
    }

    public Order getOrder(Order order){
        for(OrderItem items : order.getOrderItems()){
            Integer availableUnits = inventoryService.getStock(items.getProductId());
            if(items.getQuantity() < availableUnits) {
                inventoryService.updateStock(items.getProductId(), -items.getQuantity());
            }
        }
        if(order.getOrderType().equals("EXPRESS")){
            order.setOrderPriority(1);
        }
        else{
            order.setOrderPriority(2);
        }
        order.setOrderStatus("PLACED");
        orderRepository.save(order);
        return order;
    }

    public Order getOrderById(Long orderId){
        return orderRepository.findOrderById(orderId);
    }

    public List<Order> getAllOrder(){
        return orderRepository.getAllOrders();
    }

    public Order updateOrderStatus(Long orderId, String status){
       return orderRepository.updateStatus(orderId,status);
    }

    public Order cancelOrder(Long orderId){
        Order order = orderRepository.findOrderById(orderId);
        if(order != null){
            if(order.getOrderStatus().equals("CANCELLED")){
                throw new RuntimeException("Order already cancelled");
            }
            for(OrderItem items : order.getOrderItems()){
                inventoryService.updateStock(items.getProductId(), items.getQuantity());
            }
            order.setOrderStatus("CANCELLED");
        }
        return order;
    }
}
