package com.veterinerprojesi.app.repositories;

import com.veterinerprojesi.app.entities.Hayvan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHayvanRepo extends JpaRepository<Hayvan, Integer> {
}
