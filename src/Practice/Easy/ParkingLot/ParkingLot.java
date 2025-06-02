package Practice.Easy.ParkingLot;

import Practice.Easy.ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private final List<Level> levels;

    public ParkingLot(){
        levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance(){
        if(instance == null){
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    public boolean park(Vehicle vehicle){
        for(Level level : levels){
            if(level.park(vehicle)){
                System.out.println("Vehicle is successfully parked");
                return true;
            }
        }
        System.out.println("No spots available");
        return false;
    }

    public boolean unpark(Vehicle vehicle){
        for(Level level : levels){
            if(level.unpark(vehicle)){
                System.out.println("Vehicle unparked");
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        for(Level level : levels){
            level.displayAvailability();
        }
    }

}
