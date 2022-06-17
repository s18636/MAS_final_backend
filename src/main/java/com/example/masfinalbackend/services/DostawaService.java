package com.example.masfinalbackend.services;

import com.example.masfinalbackend.entities.Dostawa;
import com.example.masfinalbackend.repository.DostawaRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DostawaService {

    private final DostawaRepo repo;

    public DostawaService(DostawaRepo repo) {
        this.repo = repo;
    }

    public List<Dostawa> getDostepneDostawy(){
        List<Dostawa> dostawy = repo.getAllReady();
        if(dostawy.isEmpty()){
            throw new RuntimeException();
        }

        return dostawy;
    }

    public void rejestrujDostawe(){

    }
}
