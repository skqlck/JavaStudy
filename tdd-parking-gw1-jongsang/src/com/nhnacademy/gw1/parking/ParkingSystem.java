package com.nhnacademy.gw1.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingSystem {
    private ParkingLot parkingLot;
    private List<User> users;
    private static ParkingSystem parkingSystem;

    private List<Car> Log;

    private ParkingSystem(){}
    public static ParkingSystem getInstance(){
        if (parkingSystem==null) {
            parkingSystem = new ParkingSystem();
        }
        return parkingSystem;
    }
    public List<ParkingSpace> getParkingLot(){
        return this.parkingLot.getInstance();
    }
    public List<User> getUsers() {
        if (this.users == null){
            users = new ArrayList<>();
            System.out.println("No users found. Register new user");
        }
        return this.users;
    }
    public List<Car> getLog(){
        if (this.Log == null){
            this.Log = new ArrayList<>();
        }
        return this.Log;
    }
    public void delUser(User user) {
        for (int i = 0; i < this.getUsers().size(); i++) {
            if (this.getUsers().get(i).getId() == user.getId()){
                this.getUsers().remove(i);
                break;
            }
        }
    }

    public void registerUser(User newUser){
        boolean flag = true;
        for (User user: this.getUsers()){
            if (user.getId()==newUser.getId()){
                System.out.println("Already exist!!!");
                flag = false;
                break;
            }
        }
        if (flag) {
            this.getUsers().add(newUser);
        }
    }

}
