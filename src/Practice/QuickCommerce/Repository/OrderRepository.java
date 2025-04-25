package Practice.QuickCommerce.Repository;

import Practice.QuickCommerce.Models.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {
    Map<Long,Order> orders = new HashMap<>();
    Long orderIdCounter = 1L;

    public void save(Order order){
        orders.put(orderIdCounter, order);
        orderIdCounter++;
    }

    public Order findOrderById(Long orderId){
        return orders.getOrDefault(orderId, null);
    }

    public List<Order> getAllOrders(){
        List<Order> orderList = new ArrayList<>();
        for(Long orderId : orders.keySet()){
            orderList.add(orders.get(orderId));
        }
        return orderList;
    }

    public Order updateStatus(Long orderId, String status){
        if(orders.containsKey(orderId)){
            orders.get(orderId).setOrderStatus(status);
            return orders.get(orderId);
        }
        return null;
    }
}
