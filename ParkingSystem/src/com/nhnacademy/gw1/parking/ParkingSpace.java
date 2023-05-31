package com.nhnacademy.gw1.parking;
import java.time.LocalDateTime;

public class ParkingSpace {
    private String code;
    private Car car;
    private LocalDateTime time;

    ParkingSpace(String code){
        this.code = code;
    }

    private boolean canParking(){
        if (this.car == null){
            return true;
        }
        else {
            return false;
        }
    }
    private void parking(LocalDateTime time){
        this.car = car;
        this.time = time;
    }
    private void setEmpty(){
        this.car = null;
        this.time = null;
    }
    public String getCode(){ return this.code; }
    public LocalDateTime getTime() {return this.time; }
    public Car getCar() { return this.car; }
}
