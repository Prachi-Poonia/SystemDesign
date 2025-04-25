package Practice.QuickCommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long paymentId;
    private Long orderId;
    private String status; // Pending, success, failed
    private String paymentType; // cash, card, wallet or COD
    private Double amount;
}
