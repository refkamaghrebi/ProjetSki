package com.example.skirefka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skirefka.entities.Inscription;
import com.example.skirefka.entities.Skieur;

public interface InscriptionRepository extends JpaRepository<Inscription,Long > {
}
