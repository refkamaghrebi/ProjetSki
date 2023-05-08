package com.example.skirefka.repositories;

import com.example.skirefka.entities.TypeAbonnement;
import org.hibernate.annotations.OrderBy;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skirefka.entities.Abonnement;
import com.example.skirefka.entities.Skieur;

import java.time.LocalDate;
import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long > {

    List<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement);

    List<Abonnement> findAbonnementByDateDebutAndDateFin(LocalDate startDate, LocalDate endDate);

}
