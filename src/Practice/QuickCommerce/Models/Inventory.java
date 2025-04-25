package Practice.QuickCommerce.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    private Long productId;
    private String name;
    private Double price;
    private Integer stock;
}
