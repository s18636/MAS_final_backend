package com.example.masfinalbackend.services;

import com.example.masfinalbackend.entities.Delivery;
import com.example.masfinalbackend.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DeliveryService {

    private final DeliveryRepository repo;

    public DeliveryService(DeliveryRepository repo) {
        this.repo = repo;
    }

    public List<Delivery> getAvailableShipments(){
        List<Delivery> dostawy = repo.getAllReady();
        if(dostawy.isEmpty()){
            throw new RuntimeException();
        }

        return dostawy;
    }

    public void rejestrujDostawe(){

    }
}
