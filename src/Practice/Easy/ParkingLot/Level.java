package Practice.Easy.ParkingLot;

import Practice.Easy.ParkingLot.Vehicle.Vehicle;
import Practice.Easy.ParkingLot.Vehicle.VehicleType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, int spots) {
        this.floor = floor;
        this.parkingSpots = new ArrayList<>(spots);

        // Assign spots in ration of 50:40:10 for bikes, cars and trucks
        double bikes = 0.50;
        double cars = 0.40;

        int bikeSpots = (int) (spots * bikes);
        int carSpots = (int) (spots * cars);

        for(int i = 1; i <= bikeSpots; i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }

        for(int i = bikeSpots + 1; i <= bikeSpots + carSpots; i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for(int i = bikeSpots + carSpots + 1; i <= spots; i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }


    public boolean park(Vehicle vehicle){
        for(ParkingSpot spot : parkingSpots){
            if(spot.isAvailable() && spot.getVehicleType().equals(vehicle.getType())){
                spot.park(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean unpark(Vehicle vehicle){
        for (ParkingSpot spot : parkingSpots){
            if(!spot.isAvailable() && vehicle.getType() == spot.getParkedVehicle().getType()){
                spot.unparkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Level " + floor + " Availability: ");
        for (ParkingSpot spot : parkingSpots){
            System.out.println("Spot " + spot.getSpotId() + ((spot.isAvailable()) ? " Available for " : " Occupied by ") + spot.getVehicleType());
        }
    }
}
