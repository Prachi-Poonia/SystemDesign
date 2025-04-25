package Practice.Uber.Component;

import Practice.Uber.Models.Ride;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PendingRequestQueue {
    private final Queue<Ride> pendingRides = new ArrayDeque<>();
    private final HashMap<UUID,Integer> rejectionCountMap = new HashMap<>();
    private final Integer MAX_REJECTION_COUNT = 3;

    public void addRide(Ride ride){
        pendingRides.add(ride);
        rejectionCountMap.put(ride.getRideId(),0);
    }

    public Optional<Ride> getNextRide(){
        return pendingRides.isEmpty() ? Optional.empty() : Optional.of(pendingRides.poll());
    }

    public void requeueRide(Ride ride){
        int count = rejectionCountMap.getOrDefault(ride.getRideId(),0);
        if(count >= MAX_REJECTION_COUNT){
            ride.setStatus("CANCELLED");
        }
        else{
            rejectionCountMap.put(ride.getRideId(), count + 1);
            pendingRides.add(ride);
            ride.setStatus("PENDING");
        }
    }
}
