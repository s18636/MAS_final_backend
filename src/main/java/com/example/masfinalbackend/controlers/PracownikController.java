package com.example.masfinalbackend.controlers;

import com.example.masfinalbackend.entities.Pracownik;
import com.example.masfinalbackend.services.PracownikService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/pracownik")
public class PracownikController {

    private final PracownikService service;

    public PracownikController(PracownikService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public long getPracownik(long id){
        return service.getPracownik(id);
    }
}
