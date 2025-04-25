package Practice.Uber.Controller;

import Practice.Uber.Models.Ride;
import Practice.Uber.Service.DriverService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }


    @RequestMapping("/accept")
    public Ride acceptNextAvailableRide(@RequestParam UUID driverId){
        return driverService.acceptNextAvailableRide(driverId);
    }

    @RequestMapping("/rejectRide")
    public Ride rejectRide(@RequestParam UUID rideId, @RequestParam UUID driverId){
        return driverService.rejectRide(rideId,driverId);
    }
}
