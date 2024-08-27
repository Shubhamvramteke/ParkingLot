package strategy;

import constants.VehicleType;
import models.ParkingLot;
import models.ParkingSlot;
import models.Vehicle;

public interface SlotAssignmentStrategy {

    // required information
    // Vehical type
    // Parking lot

    ParkingSlot assignSlot(ParkingLot parkingLot, VehicleType vehicleType);

}
