package Practice.Uber.Service;

import Practice.Uber.Models.Ride;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DriverService {
    private final RideService rideService;

    public DriverService(RideService rideService) {
        this.rideService = rideService;
    }

    public Ride acceptNextAvailableRide(UUID driverId){
        return rideService.assignRideToDriver(driverId);
    }

    public Ride rejectRide(UUID rideId, UUID driverId){
        return rideService.rejectRide(rideId,driverId);
    }
}
