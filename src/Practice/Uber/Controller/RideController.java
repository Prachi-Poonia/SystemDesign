package Practice.Uber.Controller;

import Practice.Uber.Models.Ride;
import Practice.Uber.Service.FareEstimationService;
import Practice.Uber.Service.RideService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ride")
public class RideController {
    private final RideService rideService;
    private final FareEstimationService fareEstimationService;

    public RideController(RideService rideService, FareEstimationService fareEstimationService) {
        this.rideService = rideService;
        this.fareEstimationService = fareEstimationService;
    }

    @GetMapping("/fareEstimation")
    public Double getFareEstimate(@RequestParam Double pickUpLat,
                                  @RequestParam Double pickUpLong,
                                  @RequestParam Double dropOffLat,
                                  @RequestParam Double dropOffLong,
                                  @RequestParam String vehicleType){
        return fareEstimationService.fareEstimate(pickUpLat,pickUpLong,dropOffLat,dropOffLong,vehicleType);
    }

    @PostMapping("/confirmRide")
    public Ride confirmRide(@RequestParam UUID riderId, @RequestParam Double pickUpLat,
                            @RequestParam Double pickUpLong,
                            @RequestParam Double dropOffLat,
                            @RequestParam Double dropOffLong,
                            @RequestParam String vehicleType, @RequestParam Double fare) {
        return rideService.confirmRide(riderId,pickUpLat,pickUpLong,dropOffLat,dropOffLong,vehicleType,fare);
    }

    @PostMapping("/cancel/{rideId}")  //user can also cancel ride
    public Ride cancelRide(@PathVariable UUID rideId){
        return rideService.cancelRide(rideId);
    }

}
