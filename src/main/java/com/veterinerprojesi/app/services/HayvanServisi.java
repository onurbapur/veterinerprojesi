package com.veterinerprojesi.app.services;

import com.veterinerprojesi.app.entities.Hayvan;
import com.veterinerprojesi.app.repositories.IHastaliRepo;
import com.veterinerprojesi.app.repositories.IHayvanRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class HayvanServisi {

    IHayvanRepo iHayvanRepo;

    public HayvanServisi(IHayvanRepo iHayvanRepo) {
        this.iHayvanRepo = iHayvanRepo;
    }

    public List<Hayvan> hayvanlarinListesiniOlustur() {
        return iHayvanRepo.findAll();
    }

    public Hayvan getByTur(String hayvanTur) {
        return iHayvanRepo.getByTur(hayvanTur);
    }

    public String save(Hayvan yeniHayvan) {

        return "";
    }
}