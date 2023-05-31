package com.nhnacademy.gw1.parking;
import java.time.LocalDateTime;
public class Entrance {
    private ParkingSystem parkingSystem = ParkingSystem.getInstance();
    public String scan(Car car){
        System.out.println("Car number Scanned!");
        parkingSystem.getLog().add(car);
        return car.getNumber();
    }
}
