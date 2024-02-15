package strategies;

import model.*;
import repostories.ParkingLotRepository;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{

    private ParkingLotRepository parkingLotRepository;
    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository=parkingLotRepository;
    }

    @Override
    public ParkingSpot assignSpot(Gate gate, VehicleType vehicleType) {

        Optional<ParkingLot> optionalParkingLot=parkingLotRepository.findByGateId(gate.getId());
        ParkingLot parkingLot=null;
        if(optionalParkingLot.isPresent()){
            parkingLot=optionalParkingLot.get();
        }else {

        }
        for (ParkingFloor parkingFloor:parkingLot.getParkingFloors()){
            for(ParkingSpot parkingSpot:parkingFloor.getParkingSpots()){
                if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)
                && parkingSpot.getVehicleType().contains(vehicleType)){
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
