package Practice.QuickCommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderItem {
    private Long orderItemId;
    private Long productId;
    private Integer quantity;
    private Double price;
}
