package com.veterinerprojesi.app.services;

import com.veterinerprojesi.app.entities.Hayvan;
import com.veterinerprojesi.app.repositories.IHayvanRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HayvanServisi {

    IHayvanRepo iHayvanRepo;

    @Autowired
    public HayvanServisi(IHayvanRepo iHayvanRepo) {
        this.iHayvanRepo = iHayvanRepo;
    }

    public List<Hayvan> hayvanlarinListesiniOlustur(){
        return iHayvanRepo.findAll();
    }
}
