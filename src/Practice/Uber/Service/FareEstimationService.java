package Practice.Uber.Service;

import Practice.Uber.Models.Vehicle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FareEstimationService {
    Map<String, Vehicle> vehicleMap = new HashMap<>();

    public void setVehicleMap(Map<String, Vehicle> vehicleMap) {
        vehicleMap.put("Bike", new Vehicle("Bike",20.0,5.0));
        vehicleMap.put("Auto", new Vehicle("Auto",25.0,7.0));
        vehicleMap.put("Sedan", new Vehicle("Sedan",35.0,9.0));
    }

    public Double fareEstimate( Double pickUpLat, Double pickUpLong, Double dropOffLat, Double dropOffLong, String vehicleType){
        Double distance = calculate(pickUpLat,pickUpLong,dropOffLat,dropOffLong);
        Double baseFare, costPerKM;
        Vehicle vehicle = vehicleMap.get(vehicleType);
        baseFare = vehicle.getBaseFare();
        costPerKM = vehicle.getCostPerKM();

        return baseFare + (costPerKM * distance);

    }

    private Double calculate(Double pickUpLat, Double pickUpLong, Double dropOffLat, Double dropOffLong){
        //Haversine formula to calculate distance between two lat-long points
        return 10D;
    }
}
