package com.example.masfinalbackend.services;

import com.example.masfinalbackend.entities.Pojazd;
import com.example.masfinalbackend.enums.VechicleState;
import com.example.masfinalbackend.repository.PojazdRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PojazdService {

    private final PojazdRepo repo;

    public PojazdService(PojazdRepo repo){this.repo = repo;}

    public List<Pojazd> getDostepnePojazdy(){
        List<Pojazd> pojazdy = repo.findByStan(VechicleState.GOTOWY);
        if(pojazdy.isEmpty()) {
            throw new RuntimeException();
        }

        return pojazdy;
    }

    public void setStatus(long id, VechicleState stan){
        Optional<Pojazd> result = repo.findById(id);
        if(result.isEmpty()){
            throw new RuntimeException();
        }

        Pojazd pojazd = result.get();
        pojazd.setStan(stan);

        repo.save(pojazd);
    }
}
