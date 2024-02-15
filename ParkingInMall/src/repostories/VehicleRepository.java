package repostories;

import model.Vehicle;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicleMap=new HashMap<>();
    private Long vehicleId;

    public Optional<Vehicle> findVehicleById(Long id){
        if(vehicleMap.containsKey(id)){
            return Optional.of(vehicleMap.get(id));
        }
        return Optional.empty();
    }

    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber){
        //Iterate over the complete map and check it
        return Optional.empty();
    }


    public Vehicle save(Vehicle vehicle){
        vehicleId++;
        vehicle.setId(vehicleId);
        vehicleMap.put(vehicleId,vehicle);
        return vehicle;
    }
}
