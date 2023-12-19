package com.veterinerprojesi.app.services;

import com.veterinerprojesi.app.entities.Hastalik;
import com.veterinerprojesi.app.repositories.IHastalikRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HastalikServisi {

    private final IHastalikRepo iHastalikRepo;

    public HastalikServisi(IHastalikRepo iHastalikRepo) {
        this.iHastalikRepo = iHastalikRepo;
    }

    public List<Hastalik> hastaliklerinListesiniOlustur() {

       return iHastalikRepo.findAll();
    }


}
