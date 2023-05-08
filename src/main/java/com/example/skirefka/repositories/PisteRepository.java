package com.example.skirefka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skirefka.entities.Piste;
import com.example.skirefka.entities.Skieur;

public interface PisteRepository extends JpaRepository<Piste,Long > {
}
