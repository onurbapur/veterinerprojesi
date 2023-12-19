package com.veterinerprojesi.app.repositories;

import com.veterinerprojesi.app.entities.Hayvan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHayvanRepo extends JpaRepository<Hayvan, Integer> {
    List<Hayvan> getAllByTur(String hayvanTur);
    List<Hayvan> getAllByCins(String cins);
    List<Hayvan> getAllByAyakSayisi(Integer istekAyakSayisi);


}
