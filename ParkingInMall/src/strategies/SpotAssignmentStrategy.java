package strategies;

import model.Gate;
import model.ParkingSpot;
import model.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(Gate gate, VehicleType vehicleType);
}
