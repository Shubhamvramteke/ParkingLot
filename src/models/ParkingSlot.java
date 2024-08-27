package models;

import constants.ParkingSlotStatus;
import constants.VehicleType;

import java.util.List;

public class ParkingSlot extends BaseModel{

    private String slotNumber;
    private ParkingSlotStatus parkingSlotStatus;
    //private List<SupportedVehicleType> supportedVehicleTypes;
    private VehicleType vehicleType;

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
