package Practice.Uber.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private String vehicleType;
    private Double baseFare;
    private Double costPerKM;
}
