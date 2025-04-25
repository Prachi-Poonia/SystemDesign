package Practice.Uber.Repository;

import Practice.Uber.Models.Driver;

import java.util.*;

public class DriverRepository {
    private final HashMap<UUID, Driver> driverMap = new HashMap<>();

    public Optional<Driver> findById(UUID driverId){
        return driverMap.containsKey(driverId) ? Optional.of(driverMap.get(driverId)) : Optional.empty();
    }

    public void save(Driver driver){
        driverMap.put(driver.getDriverId(), driver);
    }

    public List<Driver> getAvailableDrivers(){
        List<Driver> availableDrivers = new ArrayList<>();
        for(UUID driverId : driverMap.keySet()){
            if(driverMap.get(driverId).isAvailable()){
                availableDrivers.add(driverMap.get(driverId));
            }
        }
        return availableDrivers;
    }
}
