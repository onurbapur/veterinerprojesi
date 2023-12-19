package com.veterinerprojesi.app.controllers;

import com.veterinerprojesi.app.entities.Hastalik;
import com.veterinerprojesi.app.services.HastalikServisi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hastalik")
public class HastalikController {

    private final HastalikServisi hastalikServisi;

    public HastalikController(HastalikServisi hastalikServisi) {
        this.hastalikServisi = hastalikServisi;
    }

    @GetMapping("/liste")
    public List<Hastalik> hastaliklerinListesiniOlustur(){
        return hastalikServisi.hastaliklerinListesiniOlustur();
    }

}
