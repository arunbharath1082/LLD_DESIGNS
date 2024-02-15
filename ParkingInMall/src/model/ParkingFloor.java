package model;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private List<ParkingSpot> parkingSpots;
    private int floorName;

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public int getFloorName() {
        return floorName;
    }

    public void setFloorName(int floorName) {
        this.floorName = floorName;
    }
}
