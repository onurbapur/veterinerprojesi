package com.veterinerprojesi.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.veterinerprojesi.app.enums.Periyot;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "ilaclar")
@Data
@JsonIgnoreProperties(value = "kullanilanHastalik",allowGetters = false)
public class Ilac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ilacAdi;
    private String etkenMaddesi;
    private Integer doz;  // günlük vücut kilogram başına mg değeri (mg/(kg.gün))
    private Periyot kullanimPeriyodu;
    private Integer kullanimSayisi;
    @ManyToOne
    @JoinColumn(name = "hastalik_id")
    private Hastalik kullanilanHastalik;

}
