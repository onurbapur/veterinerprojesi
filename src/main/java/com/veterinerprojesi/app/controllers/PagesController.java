package com.veterinerprojesi.app.controllers;

import com.veterinerprojesi.app.entities.Hayvan;
import com.veterinerprojesi.app.services.HayvanServisi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PagesController {
    private final HayvanServisi hayvanServisi;

    public PagesController(HayvanServisi hayvanServisi) {
        this.hayvanServisi = hayvanServisi;
    }

    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/hayvanlar")
    public String hayvansayfasi(Model model){
      List<Hayvan> liste =  hayvanServisi.hayvanlarinListesiniOlustur();
      model.addAttribute("tumhayvanlar", liste);
      return "hayvanlar";
    }
    @GetMapping("/hayvan/{hayv_id}")
    public String hayvanPage(Model model, @PathVariable Integer hayv_id){
        model.addAttribute("eleman",hayvanServisi.findOneById(hayv_id));

        return "hayvan";
    }
}
