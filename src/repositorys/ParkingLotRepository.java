package repositorys;

import models.Gate;
import models.ParkingLot;

import java.util.TreeMap;

public class ParkingLotRepository {
    private TreeMap<Integer, ParkingLot> parkingLots=new TreeMap<>();

    public ParkingLot findParkingLotByEntryGate(Gate gateToEnter){
        for (ParkingLot parkingLot:parkingLots.values()){
            for(Gate gate:parkingLot.getEntryGates()){
                if (gate.getId()== gateToEnter.getId()){
                    return parkingLot;
                }
            }
        }
        return null;
    }
    public ParkingLot findParkingLotById(int lotId){
        if(parkingLots.containsKey(lotId)){
            return parkingLots.get(lotId);
        }
        return null;
    }
}

// Which data structure resemble our database ? TreeMap store data in sequential manner
// To replicate database we are using tree map

