package com.veterinerprojesi.app.entities;

import com.veterinerprojesi.app.enums.HastalikTehlikesi;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hastaliklar")
@Data
public class Hastalik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hastalikAdi;
    private HastalikTehlikesi hastalikTehlikesi;
    private Boolean bulasiciMi;
    @OneToMany(mappedBy = "kullanilanHastalik")
    private List<Ilac> ilaclari;
    @ManyToMany
    @JoinTable(name = "risk_altindaki_hayvanlar")
    private List<Hayvan> riskAltindakiHayvanlar;
}
