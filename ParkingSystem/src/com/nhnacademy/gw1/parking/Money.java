package com.nhnacademy.gw1.parking;

public class Money {
    private int money;

    public Money(){
        this.money = 0;
    }
    public int getMoney(){
        return this.money;
    }

    public void withdraw(int amount){
        this.money -= amount;
    }
    public void deposit(int amount){
        this.money += amount;
    }
}
