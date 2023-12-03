package com.veterinerprojesi.app.entities;

import com.veterinerprojesi.app.enums.Ureme;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hayvanlar")
@Data
public class Hayvan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cins;
    private String tur;
    private Integer ayakSayisi;
    private Ureme uremeSekli;
    private Integer omur;
    private String yasamYeri;
    private Boolean zehirliMi;

    @ManyToMany
    @JoinTable(name = "hayvan_hastaliklari")
    private List<Hastalik> hastaliklari;
}
