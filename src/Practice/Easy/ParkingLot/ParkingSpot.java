package Practice.Easy.ParkingLot;

import Practice.Easy.ParkingLot.Vehicle.Vehicle;
import Practice.Easy.ParkingLot.Vehicle.VehicleType;
import lombok.Data;

@Data
public class ParkingSpot {
    private final int spotId;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotId, VehicleType vehicleType) {
        this.spotId = spotId;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable(){
        return parkedVehicle == null;
    }

    public synchronized void park(Vehicle vehicle){
        if(isAvailable() && vehicleType.equals(vehicle.getType())){
            parkedVehicle = vehicle;
        }
        else{
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied");
        }
    }

    public synchronized void unparkVehicle(Vehicle vehicle){
        parkedVehicle = null;
    }

}
