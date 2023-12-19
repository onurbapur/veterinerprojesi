package com.veterinerprojesi.app.controllers;

import com.veterinerprojesi.app.entities.Hayvan;
import com.veterinerprojesi.app.reqBodies.HastalikHayvanBody;
import com.veterinerprojesi.app.services.HayvanServisi;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hayvan")
public class HayvanController {

    private final HayvanServisi hayvanServisi;

    public HayvanController(HayvanServisi hayvanServisi) {
        this.hayvanServisi = hayvanServisi;
    }

    @GetMapping("/liste")
    public List<Hayvan> hayvanlarinListesiniOlustur(){
        return hayvanServisi.hayvanlarinListesiniOlustur();
    }

    @GetMapping("/getAllByTur")
    public List<Hayvan> getAllByTur(@RequestParam String hayvanTur){
        return hayvanServisi.getByTur(hayvanTur);
    }

    @PostMapping("/kaydet")
    public String save(@RequestBody Hayvan yeniHayvan){
        return hayvanServisi.save(yeniHayvan);
    }

    @GetMapping("/ayakSayisi")
    public List<Hayvan> getAllByAyakSayisi(@RequestParam Integer istakAyakSayisi){
        return hayvanServisi.getAllByAyakSayisi(istakAyakSayisi);
    }

    @GetMapping("asd/{hayv_id}")
    public Hayvan findOneById(@PathVariable Integer hayv_id){
        return hayvanServisi.findOneById(hayv_id);
    }

    @PutMapping("hastalikEkle")
    public String hayvanaHastalikEkleme(@RequestBody HastalikHayvanBody hastalikHayvanBody){
        return hayvanServisi.hayvanaHastalikEkleme(hastalikHayvanBody);
    }

}
