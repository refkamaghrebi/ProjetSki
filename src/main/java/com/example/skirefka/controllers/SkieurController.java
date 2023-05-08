package com.example.skirefka.controllers;

import com.example.skirefka.entities.TypeAbonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.skirefka.entities.Skieur;
import com.example.skirefka.entities.*;
import com.example.skirefka.services.ISkieurService;

import lombok.extern.slf4j.Slf4j;
import com.example.skirefka.services.ISkieurServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("skieur")
public class SkieurController {
    @Autowired
    ISkieurService iSkieurService;
    //localhost:9090/retrieveAllSkieurs
    @GetMapping
    public List<Skieur> getAll(){
        return iSkieurService.retrieveAllSkieurs();

    }
    @GetMapping("{numSkieur}")

    public Optional<Skieur> retrieveSkieur(@PathVariable Long numSkieur) {

        return  iSkieurService.retrieveSkieur(numSkieur);

    }
    @PostMapping

    public Skieur addSkieur(@RequestBody Skieur skieur){

        return iSkieurService.addSkieur(skieur);
    }
    @DeleteMapping("{numSkieur}")
    public void removeSkieur(@PathVariable Long numSkieur){

        iSkieurService.removeSkieur(numSkieur);
    }

    @PutMapping
    public Skieur updateSkieur(@RequestBody Skieur Skieur) {

        return  iSkieurService.updateSkieur(Skieur);

    }
    @PutMapping("p/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable Long numSkieur,@PathVariable Long numPiste){
        return iSkieurService.assignSkierToPiste(numSkieur, numPiste);
    }

    @PutMapping("s/{numSkieur}/{numAbon}")
    public Skieur AssignSkierToSubscription(@PathVariable Long numSkieur, @PathVariable Long numAbon) {
        return iSkieurService.AssignSkierToSubscription(numSkieur, numAbon);
    }
    @GetMapping("getSkieurParTypeAbon/{tp}")
    public List<Skieur> getSkieurParTypeAbon(@PathVariable TypeAbonnement tp){
        return  iSkieurService.getSkieurByAbonnement_TypeAbon(tp);
    }

    @GetMapping("getby/{inscriptions_cours_typeCours}/{inscriptions_cours_support}/{pistes_couleur}")
    public List<Skieur> findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(@PathVariable("inscriptions_cours_typeCours") TypeCours inscriptions_cours_typeCours,@PathVariable("inscriptions_cours_support") Support inscriptions_cours_support,@PathVariable("pistes_couleur") Couleur pistes_couleur){
        return iSkieurService.findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(inscriptions_cours_typeCours, inscriptions_cours_support, pistes_couleur);
    }
    @GetMapping("find/{support}/{nom}")
    public List<Skieur> findByMoniteurNameAndSupportTypeJPQL(@PathVariable("support") Support support, @PathVariable("nom") String nom)
    {
        log.info(""+support);
        return iSkieurService.findByMoniteurNameAndSupportTypeJPQL(support, nom);
    }
    @PostMapping("addSkierAndAssignToCourse")
    Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur){
        return iSkieurService.addSkierAndAssignToCourse(skieur);
    }
}
