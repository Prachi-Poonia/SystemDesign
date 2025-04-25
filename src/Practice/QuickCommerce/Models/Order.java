package Practice.QuickCommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long orderId;
    private Long customerId;
    private String orderType; // Express, sustainable
    private Integer orderPriority;
    private Double amount;
    private String orderStatus; // placed, cancelled, delivered, out for delivery
    private List<OrderItem> orderItems;
}
