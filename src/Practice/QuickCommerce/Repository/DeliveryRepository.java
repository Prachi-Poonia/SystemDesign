package Practice.QuickCommerce.Repository;

import Practice.QuickCommerce.Controller.Delivery;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DeliveryRepository {
    Map<Long,Delivery> deliveryMap = new HashMap<>();
    Long deliveryIdCounter = 1L;
    Long deliveryAgentCounter = 1L;

    public Delivery findById(Long orderId){
        if(deliveryMap.containsKey(orderId)){
            return deliveryMap.get(orderId);
        }
        return null;
    }
    public void assignDelivery(Long orderId){
        Delivery delivery = findById(orderId);
        if(delivery != null){
            delivery.setDeliveryAgentId(deliveryAgentCounter++);
            delivery.setStatus("ASSIGNED");
        }
    }
}
