package com.veterinerprojesi.app.services;

import com.veterinerprojesi.app.entities.Hastalik;
import com.veterinerprojesi.app.entities.Hayvan;
import com.veterinerprojesi.app.repositories.IHastalikRepo;
import com.veterinerprojesi.app.repositories.IHayvanRepo;
import com.veterinerprojesi.app.reqBodies.HastalikHayvanBody;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class HayvanServisi {

    private final IHayvanRepo iHayvanRepo;
    private final IHastalikRepo iHastalikRepo;

    public HayvanServisi(IHayvanRepo iHayvanRepo, IHastalikRepo iHastalikRepo) {
        this.iHayvanRepo = iHayvanRepo;
        this.iHastalikRepo = iHastalikRepo;
    }

    public List<Hayvan> hayvanlarinListesiniOlustur() {
        return iHayvanRepo.findAll();
    }

    public List<Hayvan> getByTur(String hayvanTur) {
        List<Hayvan> list1 = iHayvanRepo.getAllByTur(hayvanTur);
        List<Hayvan> list2 = iHayvanRepo.getAllByTur(hayvanTur.replace('I', 'ı'));

        list2.addAll(list1);

        return list2;
    }

    public String save(Hayvan yeniHayvan) {

        // tur ismi ve cins ismi ikisi de hem null ve hem boş olmasın. --
        if (yeniHayvan.getTur() == null || yeniHayvan.getCins() == null || yeniHayvan.getCins().equals("") || yeniHayvan.getTur().equals("")) {
            return "Lütfen Cins ve Tür isimlerini doldurun !";
        }

        List<Hayvan> cinsAyniHayvanlar = iHayvanRepo.getAllByCins(yeniHayvan.getCins());

        // Aynı tur ve aynı cins isimiyle kayıt yapmasın // tur ve cins ismlerinden biri farklı ise kayıt yapsın
        for (Hayvan controlHayvan : cinsAyniHayvanlar) {
            if (controlHayvan.getTur().equals(yeniHayvan.getTur()))
                return "Bu hayvan zaten kayıtlıdır!";
        }

        iHayvanRepo.save(yeniHayvan);
        return "Kayıt başarılı.";
    }

    public List<Hayvan> getAllByAyakSayisi(Integer istekAyakSayisi) {
        return iHayvanRepo.getAllByAyakSayisi(istekAyakSayisi);
    }

    public Hayvan findOneById(Integer hayv_id) {
        return iHayvanRepo.findById(hayv_id).get();
    }

    public String hayvanaHastalikEkleme(HastalikHayvanBody hastalikHayvanBody) {

        Hayvan hayvan = iHayvanRepo.findById(hastalikHayvanBody.getHayvanId()).get();
        List<Hastalik> hastalikList = new ArrayList<>();
        List<Integer> idList = hastalikHayvanBody.getHastaliklar();

        System.out.println("idList.toString()");

        for (Integer hastalikId: idList) {
           hastalikList.add(iHastalikRepo.findById(hastalikId).get());
           hayvan.getHastaliklari().add(iHastalikRepo.findById(hastalikId).get());
           iHayvanRepo.save(hayvan);

        }


       return "Başarılı";
    }
}
