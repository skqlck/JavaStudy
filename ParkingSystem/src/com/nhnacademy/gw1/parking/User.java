package com.nhnacademy.gw1.parking;

import java.util.HashSet;

public class User {
    private UserId id;
    private Money amount;

    private HashSet<Car> ownCar;
    User(UserId userId, Money amount){
        this.id = userId;
        this.amount = amount;
        this.ownCar = new HashSet<>();
    }
    public UserId getId(){
        return this.id;
    }
    public void addCar(Car car){
        this.ownCar.add(car);
    }

    public HashSet<Car> getOwnCar(){
        return this.ownCar;
    }
}