package com.example.IRCTC.Services;

import com.example.IRCTC.Models.FoodOrder;
import com.example.IRCTC.Models.Passenger;
import com.example.IRCTC.Models.Train;
import com.example.IRCTC.Repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;


    public String addPassenger(Passenger passenger) {
        //Add a Passenger with ticketId , trainId ,Date,age,gender
        passengerRepository.save(passenger);
        return "Passenger added";
    }

    public Integer findPassengerFromSourceToDestination(String x, String y, Date d) {
        //Find the Number of passengers traveling from City X and City Y on Date D

        List<Passenger>passengers=passengerRepository.findAll();
        int count=0;
        for(Passenger passenger: passengers){
            Train train=passenger.getTrain();
            if(train.getSource().equalsIgnoreCase(x)&&train.getDestination().equalsIgnoreCase(y)&&passenger.getDate().compareTo(d)==0){
                count++;
            }
        }
        return  count;

        /*                          OR
            We can create a custom  query for this in Repository layer
            ex : @Query(value="SELECT * FROM passangers WHERE source=:x AND destination=:y AND date=:d",nativeQuery=true)
            public Integer findPassengerFromSourceToDestination(String x,String y, Date d);
         */

    }

    public Integer getTotalFemalePassenger(int x, int y, String destination) {
        //Find total No of  female passengers of age between X and Y(X < = Y) who ended their destination at city C.
        List<Passenger>passengers=passengerRepository.findAll();
        int count=0;
        int amount;
        for(Passenger passenger: passengers){
           if(passenger.getGender().equalsIgnoreCase("female")&& passenger.getAge()>x && passenger.getAge()<y && passenger.getTrain().getDestination().equalsIgnoreCase(destination)){
               count++;
           }
        }
        return  count;
         /*                         OR
            We can create a custom  query for this in Repository layer
            ex : @Query(value="SELECT * FROM passangers WHERE gender="female" AND age BETWEEN :X AND :Y AND destination =:destination",nativeQuery=true)
            public Integer getTotalFemalePassenger(int x, int y, String destination);
         */
    }

    public Integer getOrderPrice(Date D, int T) {
        //Get the total price of the orders placed by Customers on Date D in TrainId T.
        List<Passenger>passengers=passengerRepository.findAll();
        int total=0;
        for(Passenger passenger : passengers){
            if(passenger.getTrain().getId()==T && passenger.getDate().compareTo(D)==0){
                List<FoodOrder>foodOrders=passenger.getFoodOrderList();
                for(FoodOrder foodOrder : foodOrders){
                    total+=foodOrder.getPrice();
                }
            }
        }
        return total;

    }
}
