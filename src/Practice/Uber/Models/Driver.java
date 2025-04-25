package Practice.Uber.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver{
    private UUID driverId;
    private String name;
    private Location location;
    private String licenseNo;
    private Vehicle vehicle;
    private boolean isAvailable;
}
