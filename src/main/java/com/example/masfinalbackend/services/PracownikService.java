package com.example.masfinalbackend.services;

import com.example.masfinalbackend.entities.Pracownik;
import com.example.masfinalbackend.repository.PracownikRepo;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PracownikService {

    private final PracownikRepo repo;


    public PracownikService(PracownikRepo repo){
        this.repo = repo;
    }

    public long getPracownik(long id){
        Optional<Pracownik> pracownik = repo.findById(id);
        if(pracownik.isEmpty()){
            throw new RuntimeException();
        }
        return id;
    }

//    public void deletePracownik(long id){
//        repo.delete(getPracownik(id));
//    }

}
