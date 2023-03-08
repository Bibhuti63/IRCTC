package com.example.IRCTC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IrctcApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrctcApplication.class, args);
	}

}
/*

Create an IRCTC system:

Train = TrainNo, Source, Destination
Passenger = TicketId, TrainId ,Date, Age, Gender
FoodOrder = TicketId, TrainId, Price

POST API - Add a Passenger with ticketId , trainId ,Date,age,gender
POST API - Add a Train with trainNo , source ,destination .

1.GET API - Find the Number of passengers traveling from City X and City Y on Date D
2.GET API - Find total No of  female passengers of age between X and Y(X < = Y) who ended their destination at city C.
3.GET API - Get the total price of the orders placed by Customers on Date D in TrainId T.
 */
