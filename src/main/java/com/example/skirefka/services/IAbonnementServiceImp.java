package com.example.skirefka.services;

import com.example.skirefka.entities.TypeAbonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.skirefka.entities.Abonnement;
import com.example.skirefka.repositories.AbonnementRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class IAbonnementServiceImp implements IAbonnementService{

    @Autowired
    AbonnementRepository abonnementRepository;
    @Override
    public List<Abonnement> retrieveAllAbonnement() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement retrieveAbonnement(Long numAbon) {
        return abonnementRepository.findById(numAbon).orElse(null);
    }

    @Override
    public void removeAbonnement(Long numAbon) {
        abonnementRepository.deleteById(numAbon);
    }

    @Override
    public List<Abonnement> getSubParType(TypeAbonnement typeAbonnement){
        return abonnementRepository.findByTypeAbon(typeAbonnement);
    }
    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate dateDebut, LocalDate dateFin){
        return  abonnementRepository.findAbonnementByDateDebutAndDateFin(dateDebut,dateFin);
    }
}
