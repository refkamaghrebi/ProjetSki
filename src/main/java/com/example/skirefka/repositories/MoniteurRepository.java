package com.example.skirefka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skirefka.entities.Moniteur;
import com.example.skirefka.entities.Skieur;

public interface MoniteurRepository extends JpaRepository<Moniteur,Long > {
}
