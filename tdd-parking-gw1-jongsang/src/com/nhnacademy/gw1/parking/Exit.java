package com.nhnacademy.gw1.parking;

import java.time.*;

public class Exit {
    private ParkingSystem parkingSystem = ParkingSystem.getInstance();
    public void pay(Car car){
        Long initial_fee =3000L;
        Long day_fee = 10000L;
        Long ten_minute_fee = 500L;
        ParkingSpace targetSpace = null;
        User Carowner = null;
        for (ParkingSpace space : parkingSystem.getParkingLot()){
            if (space.getCar().getNumber() == car.getNumber()){
                targetSpace = space;
                break;
            }
        }
        for (User user : parkingSystem.getUsers()){
            if (user.getOwnCar().contains(car)){
                Carowner = user;
                break ;
            }
        }
        if (targetSpace == null || Carowner == null){
            System.out.println("The car is not in parking space or no owner");
            return;
        }
        LocalDate outDate = LocalDate.now();
        LocalTime outTime = LocalTime.now();
        Period dates = Period.between(targetSpace.getTime().toLocalDate(), outDate);
        Duration duration = Duration.between(targetSpace.getTime().toLocalTime(), outTime);
        Long total_fee = 0L;
        total_fee += initial_fee;
        int days = 0;
        days += dates.getYears()*365;
        days += dates.getMonths()*30;
        days += dates.getDays();

        Long seconds = 0L;
        seconds += duration.getSeconds();

        }

}
