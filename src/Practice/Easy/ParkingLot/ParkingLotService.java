package Practice.Easy.ParkingLot;

import Practice.Easy.ParkingLot.Vehicle.Car;
import Practice.Easy.ParkingLot.Vehicle.Motorcycle;
import Practice.Easy.ParkingLot.Vehicle.Truck;
import Practice.Easy.ParkingLot.Vehicle.Vehicle;

public class ParkingLotService {
    public static void main(String[] args){
        ParkingLot parkingLot = ParkingLot.getInstance();

        parkingLot.addLevel(new Level(1,10));
        parkingLot.addLevel(new Level(2,8));

        Vehicle car = new Car("ABCD123");
        Vehicle bike = new Motorcycle("EFGH456");
        Vehicle truck = new Truck("WXYZ789");

        parkingLot.park(car);
        parkingLot.park(bike);
        parkingLot.park(truck);

        parkingLot.displayAvailability();

        parkingLot.unpark(bike);

        parkingLot.displayAvailability();
    }
}
