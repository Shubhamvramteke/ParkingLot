package models;

import java.util.Date;

public class Ticket extends BaseModel{
    private Date entryTime;
    private Gate gate;
    //Gate will contain current operator at the gate
    //this operator will contain the operator details, which was present when ticket was issued
    private Operator operator;
    private ParkingSlot parkingSlot;
    private Vehicle vehical;

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Vehicle getVehical() {
        return vehical;
    }

    public void setVehical(Vehicle vehical) {
        this.vehical = vehical;
    }
}
