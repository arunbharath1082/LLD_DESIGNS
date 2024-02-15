package services;

import exceptions.GateNotFoundException;
import factories.SpotAssignmentStrategyFactory;
import model.*;
import repostories.GateRepository;
import repostories.ParkingLotRepository;
import repostories.TicketRepository;
import repostories.VehicleRepository;
import strategies.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                        TicketRepository ticketRepository){
        this.gateRepository=gateRepository;
        this.vehicleRepository=vehicleRepository;
        this.ticketRepository=ticketRepository;
        this.parkingLotRepository=parkingLotRepository;

    }
    public Ticket issueTicket(Long gateId, String ownerName, VehicleType vehicleType
                                ,String vehicleNumber) throws GateNotFoundException {
        Optional<Gate> optionalGate=gateRepository.findGateById(gateId);
        Gate gate=null;
        Operator operator=null;
        Vehicle vehicle=null;

        if(optionalGate.isPresent()){
            gate=optionalGate.get();
            operator=optionalGate.get().getCurrentOperator();
        }else{
            throw new GateNotFoundException("Invalid gate id");
        }
        Optional<Vehicle> optionalVehicle=vehicleRepository.findVehicleByNumber(vehicleNumber);
        if(optionalVehicle.isPresent()){
            vehicle=optionalVehicle.get();

        }else{
            vehicle=new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            vehicle.setVehicleType(vehicleType);
            vehicle=vehicleRepository.save(vehicle);

        }
        SpotAssignmentStrategy spotAssignmentStrategy= SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(
                SpotAssignmentStrategyType.RANDOM,parkingLotRepository);

        ParkingSpot parkingSpot=spotAssignmentStrategy.assignSpot(gate,vehicleType);

        Ticket ticket=new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setNumber(String.valueOf(new Random().nextInt()));
        ticket.setVehicle(vehicle);
        ticket.setGeneratedBy(operator);
        ticket.setParkingSpot(parkingSpot);
        ticket.setGeneratedAt(gate);
        ticket=ticketRepository.save(ticket);
        return ticket;


    }


}
