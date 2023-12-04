package com.veterinerprojesi.app.controllers;

import com.veterinerprojesi.app.entities.Hayvan;
import com.veterinerprojesi.app.repositories.IHayvanRepo;
import com.veterinerprojesi.app.services.HayvanServisi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hayvan")
public class HayvanController {

    HayvanServisi hayvanServisi;

    @Autowired
    public HayvanController(HayvanServisi hayvanServisi) {
        this.hayvanServisi = hayvanServisi;
    }

    @GetMapping("/liste")
    public List<Hayvan> hayvanlarinListesiniOlustur(){
        return hayvanServisi.hayvanlarinListesiniOlustur();
    }
}
