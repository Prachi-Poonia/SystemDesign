package Practice.Easy.VendingMachine;

import lombok.Data;

@Data
public class Product {
    private final String productName;
    private final double price;

    public Product(String name, double price){
        this.productName = name;
        this.price = price;
    }
}
