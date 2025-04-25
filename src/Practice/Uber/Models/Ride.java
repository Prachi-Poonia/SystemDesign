package Practice.Uber.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ride {
    private UUID rideId;
    private UUID driverId;
    private UUID userId;
    private Double fare;
    private Location pickup;
    private Location dropOff;
    private String status;
    private String vehicleType;
}
