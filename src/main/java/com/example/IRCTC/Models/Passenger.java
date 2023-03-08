package com.example.IRCTC.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int TicketId;

    private Date date;

    private int Age;

    private String Gender; //we can use enum for gender also.



    //Passenger to Train mapping
    @ManyToOne
    @JoinColumn
    private Train train;

    //passenger to foodOrder mapping
    @OneToMany(mappedBy = "passenger",cascade = CascadeType.ALL)
    private List<FoodOrder>foodOrderList=new ArrayList<>();

    public Passenger() {
    }

    public int getTicketId() {
        return TicketId;
    }

    public void setTicketId(int ticketId) {
        TicketId = ticketId;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public List<FoodOrder> getFoodOrderList() {
        return foodOrderList;
    }

    public void setFoodOrderList(List<FoodOrder> foodOrderList) {
        this.foodOrderList = foodOrderList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
