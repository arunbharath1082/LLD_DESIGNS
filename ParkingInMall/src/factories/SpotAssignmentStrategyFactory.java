package factories;

import model.SpotAssignmentStrategyType;
import repostories.ParkingLotRepository;
import strategies.CheapestSpotAssignmentStrategy;
import strategies.RandomSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(
            SpotAssignmentStrategyType spotAssignmentStrategyType, ParkingLotRepository parkingLotRepository
            ){
        if (spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.RANDOM)){
            return new RandomSpotAssignmentStrategy(parkingLotRepository);
        }else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.CHEAPEST)){
            return new CheapestSpotAssignmentStrategy();
        }
            return null;
    }
}
