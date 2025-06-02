package Practice.Easy.ParkingLot.Vehicle;

import lombok.Data;

@Data
public abstract class Vehicle {
    private final String licensePlate;
    private final VehicleType type;

    Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }
}
