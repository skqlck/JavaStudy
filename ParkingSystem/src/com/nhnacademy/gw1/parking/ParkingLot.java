package com.nhnacademy.gw1.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpace> spaces;
    private ParkingLot(){};
    public List<ParkingSpace> getInstance(){
        if (this.spaces == null){
            spaces = new ArrayList<>();
        }
        return spaces;
    }
    public void enter(){};
    public void exit(){};

    public void addParkingSpace(ParkingSpace newSpace){
        boolean flag = true;
        for (ParkingSpace space : this.getInstance()){
            if (space.getCode().equals(newSpace.getCode())) {
                System.out.println("This parking space already exist!");
                flag = false;
                break;
            }
        }
        if (flag){
            this.getInstance().add(newSpace);
        }
    }
}
