package Practice.Uber.Service;

import Practice.Uber.Component.PendingRequestQueue;
import Practice.Uber.Models.Driver;
import Practice.Uber.Models.Location;
import Practice.Uber.Models.Ride;
import Practice.Uber.Repository.DriverRepository;
import Practice.Uber.Repository.RideRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RideService {

    private final RideRepository rideRepository;

    private final PendingRequestQueue pendingRequestQueue;
    private final DriverRepository driverRepository;

    public RideService(RideRepository rideRepository, PendingRequestQueue pendingRequestQueue, DriverRepository driverRepository) {
        this.rideRepository = rideRepository;
        this.pendingRequestQueue = pendingRequestQueue;
        this.driverRepository = driverRepository;
    }

    public Ride confirmRide(UUID riderId, Double pickUpLat, Double pickUpLong,
                            Double dropOffLat, Double dropOffLong, String vehicleType, Double fare){
        Ride ride = new Ride();
        ride.setRideId(UUID.randomUUID());
        ride.setPickup(new Location(pickUpLat,pickUpLong));
        ride.setDropOff(new Location(dropOffLat,dropOffLong));
        ride.setFare(fare);
        ride.setUserId(riderId);
        ride.setVehicleType(vehicleType);
        ride.setStatus("REQUESTED");

        pendingRequestQueue.addRide(ride);
        rideRepository.save(ride);
        return ride;
    }

    public Ride assignRideToDriver(UUID driverId){
        Optional<Ride> ride = pendingRequestQueue.getNextRide();
        Optional<Driver> driver = driverRepository.findById(driverId);

        if(driver.get().isAvailable()){
            ride.get().setStatus("ASSIGNED");
            ride.get().setDriverId(driverId);
            driver.get().setAvailable(false);
        }

        rideRepository.save(ride.get());
        driverRepository.save(driver.get());

        return ride.get();
    }

    public Ride rejectRide(UUID rideId, UUID driverId){
        Ride ride = rideRepository.getRideById(rideId);
        pendingRequestQueue.requeueRide(ride);
        Optional<Driver> driver = driverRepository.findById(driverId);
        driver.get().setAvailable(true);
        driverRepository.save(driver.get());
        rideRepository.save(ride);
        return ride;
    }

    public Ride cancelRide(UUID rideId){
        Ride ride = rideRepository.getRideById(rideId);
        ride.setStatus("CANCELLED");
        rideRepository.save(ride);
        return ride;
    }

}
