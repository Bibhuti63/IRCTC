package com.example.IRCTC.Services;

import com.example.IRCTC.Models.Train;
import com.example.IRCTC.Repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;

    public String addTrain(Train train) {
        //Add a Train with trainNo , source ,destination .
        trainRepository.save(train);
        return "Train added Successfully";
    }
}
