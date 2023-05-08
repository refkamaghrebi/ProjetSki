package com.example.skirefka.controllers;
import com.example.skirefka.entities.TypeAbonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.example.skirefka.entities.Abonnement;
import com.example.skirefka.entities.Moniteur;
import com.example.skirefka.services.IAbonnementService;
import com.example.skirefka.services.IMoniteurService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("abonnement")

public class AbonnementController {
    @Autowired
    IAbonnementService iAbonnementService;
    @GetMapping
    public List<Abonnement> getAll(){
        return iAbonnementService.retrieveAllAbonnement();

    }
    @GetMapping("{numAbon}")

    public Abonnement retrieveAbonnement(@PathVariable Long numAbon) {

        return  iAbonnementService.retrieveAbonnement(numAbon);

    }
    @PostMapping

    public Abonnement addAbonnement(@RequestBody Abonnement abonnement){

        return iAbonnementService.addAbonnement(abonnement);
    }
    @DeleteMapping("{numAbon}")
    public void removeAbonnement(@PathVariable Long numAbon){

        iAbonnementService.removeAbonnement(numAbon);
    }

    @PutMapping
    public Abonnement updateAbonnement(@RequestBody Abonnement abonnement) {

        return  iAbonnementService.updateAbonnement(abonnement);

    }

    @GetMapping("abParType/{tp}")
    public List<Abonnement> getAbonParType(@PathVariable TypeAbonnement tp){
        return  iAbonnementService.getSubParType(tp);
    }

    @GetMapping("abParDate/{dateDebut}/{dateFin}")
    public List<Abonnement>getAbonParDate (@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDebut, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFin){
        return  iAbonnementService.retrieveSubscriptionsByDates(dateDebut,dateFin);
    }
}
