package com.example.masfinalbackend.services;

import com.example.masfinalbackend.entities.Vehicle;
import com.example.masfinalbackend.enums.VechicleState;
import com.example.masfinalbackend.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleService {

    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo){this.repo = repo;}

    public List<Vehicle> getAvailableVehicles(){
        List<Vehicle> vehicles = repo.findByState(VechicleState.GOTOWY);
        if(vehicles.isEmpty()) {
            throw new RuntimeException();
        }
        return vehicles;
    }

    public void setStatus(long id, VechicleState state){
        Optional<Vehicle> result = repo.findById(id);
        if(result.isEmpty()){
            throw new RuntimeException();
        }

        Vehicle vehicle = result.get();
        vehicle.setState(state);

        repo.save(vehicle);
    }
}
