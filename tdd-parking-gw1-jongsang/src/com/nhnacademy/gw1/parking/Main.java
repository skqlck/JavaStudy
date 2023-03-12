package com.nhnacademy.gw1.parking;

public class Main {
    public static void main(String[] args){
        Car car1 = new Car("12가1234");
        Entrance entrance1 = new Entrance();
        String carNumber = entrance1.scan(car1);
    }
}
