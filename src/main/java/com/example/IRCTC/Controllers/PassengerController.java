package com.example.IRCTC.Controllers;

import com.example.IRCTC.Models.Passenger;
import com.example.IRCTC.Services.PassengerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @PostMapping("/add")
    public ResponseEntity<String> addPassenger(@RequestBody Passenger passenger){
        String response=passengerService.addPassenger(passenger);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public  Integer findPassengerFromSourceToDestination(@RequestParam("source") String x, @RequestParam("destination") String y, @RequestParam("date") Date d){
        return passengerService.findPassengerFromSourceToDestination(x,y,d);
    }

    @GetMapping("/getFemale")
    public Integer getTotalFemalePassenger(@RequestParam("x") int x, @RequestParam("y") int y,@RequestParam("c") String c){
        return passengerService.getTotalFemalePassenger(x,y,c);
    }

    @GetMapping("/getOrderPrice")
    public Integer getOrderPrice(@RequestParam("date") Date d,@RequestParam("id") int trainId){
        return passengerService.getOrderPrice(d, trainId);
    }
}
