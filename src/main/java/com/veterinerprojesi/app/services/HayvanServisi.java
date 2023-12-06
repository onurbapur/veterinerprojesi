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
    public List<Hayvan> getByTur(String hayvanTur) {
        return iHayvanRepo.getAllByTur(hayvanTur);
    }

    public String save(Hayvan yeniHayvan) {

        // tur ismi ve cins ismi ikisi de hem null ve hem boş olmasın. --
        if (yeniHayvan.getTur() == null || yeniHayvan.getCins() == null || yeniHayvan.getCins().equals("") || yeniHayvan.getTur().equals("")) {
            return "Lütfen Cins ve Tür isimlerini doldurun !";
        }

        List<Hayvan> cinsAyniHayvanlar = iHayvanRepo.getAllByCins(yeniHayvan.getCins());

        // Aynı tur ve aynı cins isimiyle kayıt yapmasın // tur ve cins ismlerinden biri farklı ise kayıt yapsın
        for (Hayvan controlHayvan:cinsAyniHayvanlar) {
            if (controlHayvan.getTur().equals(yeniHayvan.getTur()))
                return "Bu hayvan zaten kayıtlıdır!";
        }

        iHayvanRepo.save(yeniHayvan);
        return "Kayıt başarılı.";
    }
}
