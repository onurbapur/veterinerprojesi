package com.veterinerprojesi.app.controllers;

import com.veterinerprojesi.app.entities.Hayvan;
import com.veterinerprojesi.app.services.HayvanServisi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getByTur")
    public Hayvan getByTur(@RequestParam String hayvanTur){
        return hayvanServisi.getByTur(hayvanTur);
    }

    @PostMapping("/kaydet")
    public String save(Hayvan yeniHayvan){
        return hayvanServisi.save(yeniHayvan);
    }
}
