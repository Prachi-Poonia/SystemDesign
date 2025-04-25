package Practice.QuickCommerce.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
    private Long deliveryId;
    private Long deliveryAgentId;
    private Long orderId;
    private String status; //OUT FOR DELIVERY, DELIVERED
}
