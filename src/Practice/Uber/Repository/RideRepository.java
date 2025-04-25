package Practice.Uber.Repository;

import Practice.Uber.Models.Ride;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class RideRepository {
    HashMap<UUID, Ride> rideMap = new HashMap<>();

    public void save(Ride ride){
        rideMap.put(ride.getRideId(), ride);
    }

    public Ride getRideById(UUID rideId){
        return rideMap.get(rideId);
    }
}
