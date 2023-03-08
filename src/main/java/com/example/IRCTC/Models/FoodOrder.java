package com.example.IRCTC.Models;

import javax.persistence.*;

@Entity
@Table(name = "food_orders")
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double price;


    //food order to train
    @ManyToOne
    @JoinColumn
    private Train train;

    //food order to passenger
    @ManyToOne
    @JoinColumn
    private Passenger passenger;

    public FoodOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
