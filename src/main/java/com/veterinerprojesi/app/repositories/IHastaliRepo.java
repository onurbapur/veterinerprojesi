package com.veterinerprojesi.app.repositories;

import com.veterinerprojesi.app.entities.Hastalik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHastaliRepo extends JpaRepository<Hastalik, Integer> {
}
