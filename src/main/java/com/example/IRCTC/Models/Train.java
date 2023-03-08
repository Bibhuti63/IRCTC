package com.example.IRCTC.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="trains")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int TrainNo;

    private String Source;

    private String Destination;

    //train-passenger mapping
    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    private List<Passenger> passengerList=new ArrayList<>();

    //train-ticket mapping
    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    private List<FoodOrder>foodOrderList=new ArrayList<>();


    public Train() {
    }

    public int getTrainNo() {
        return TrainNo;
    }

    public void setTrainNo(int trainNo) {
        TrainNo = trainNo;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public List<FoodOrder> getFoodOrderList() {
        return foodOrderList;
    }

    public void setFoodOrderList(List<FoodOrder> foodOrderList) {
        this.foodOrderList = foodOrderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
