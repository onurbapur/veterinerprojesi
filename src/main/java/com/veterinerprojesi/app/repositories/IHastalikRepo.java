package com.veterinerprojesi.app.repositories;

import com.veterinerprojesi.app.entities.Hastalik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHastalikRepo extends JpaRepository<Hastalik, Integer> {
}
