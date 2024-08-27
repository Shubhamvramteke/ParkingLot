package services;

import constants.SlotAssignmentStrategyType;
import constants.VehicleType;
import models.*;
import repositorys.GateRepository;
import repositorys.TickitRepository;
import repositorys.VehicleRepository;
import strategy.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepositroy;
    private VehicleRepository  vehicleRepository;
    private TickitRepository tickitRepository;
    public TicketService(GateRepository gateRepositroy, VehicleRepository vehicleRepository,TickitRepository tickitRepository){
        this.gateRepositroy=gateRepositroy;
        this.vehicleRepository=vehicleRepository;
        this.tickitRepository=tickitRepository;
    }
    public Ticket issueTicket(int gateId, String vehicleNumber, String ownerName, VehicleType vehicleType){
       //To Create ticket objects what all info we required


        // 1) Properly create ticket object with required details
        Ticket ticket=new Ticket();
        //Set Entry Time
        ticket.setEntryTime(new Date());

        //Set Gate
        Optional<Gate> gateOptional=gateRepositroy.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new RuntimeException("Gate not found Exception");
        }
        Gate gate=gateOptional.get();
        ticket.setGate(gate);

        ticket.setOperator(gate.getOperator());

        Optional<Vehicle> vehicleOptional=vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle vehicle;
        if(vehicleOptional.isEmpty()){
            vehicle=new Vehicle();
            vehicle.setLicencePlateNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            vehicle.setVehicleType(vehicleType);
            vehicle=vehicleRepository.saveVehicle(vehicle);
        }
        else{
            vehicle=vehicleOptional.get();
        }
        ticket.setVehical(vehicle);


        //2) Assign the slots on floor
        ParkingLot parkingLot= gate.getParkingLot();
        ParkingSlot parkingSlot=
                SlotAssignmentStrategyFactory.getSlotAssignmentStrategyBy(parkingLot.getSlotAssignmentStrategyType())
                        .assignSlot(parkingLot,vehicleType);
        ticket.setParkingSlot(parkingSlot);

        // Save the tickit
        // 3) RETURN THE DATA
        return  tickitRepository.saveTicket(ticket);
    }
}
