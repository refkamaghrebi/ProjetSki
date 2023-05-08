package com.example.skirefka.services;

import com.example.skirefka.entities.Abonnement;
import com.example.skirefka.entities.TypeAbonnement;
import com.example.skirefka.repositories.AbonnementRepository;
import com.example.skirefka.repositories.PisteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.skirefka.entities.Piste;
import com.example.skirefka.entities.Skieur;
import com.example.skirefka.entities.Cours;
import com.example.skirefka.repositories.SkieurRepository;
import com.example.skirefka.repositories.InscriptionRepository;
import com.example.skirefka.repositories.CoursRepository;
import org.springframework.util.Assert;
import com.example.skirefka.entities.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class ISkieurServiceImp implements ISkieurService{
    @Autowired
    SkieurRepository skieurRepository;
    @Autowired
    PisteRepository pisteRepo;
    @Autowired
    AbonnementRepository abonnementRepo;
    @Autowired
    InscriptionRepository inscriptionRepository;
    @Autowired
     CoursRepository coursRepository;

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return  skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }


    @Override
    public void removeSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);
    }

    @Override
    public Optional<Skieur> retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur);
    }

    @Override
    public Skieur updateSkieur(Skieur Skieur) {
        return skieurRepository.save(Skieur);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {

        Skieur skieur =  skieurRepository.findById(numSkieur).orElse(null);
        Piste piste = pisteRepo.findById(numPiste).orElse(null);

        if(skieur!=null && piste!=null){

           // piste.getSkieurs().add(skieur);
            Set<Piste> pistes = skieur.getPistes();
            pistes.add(piste);
            skieur.setPistes(pistes);
            return skieurRepository.save(skieur);
        }
        //return skieurRepository.findById(numSkieur).orElse(null);
        return  null ;
    }

    @Override
    public Skieur AssignSkierToSubscription(Long numSkieur, Long  numAbon) {
        Skieur skieur =  skieurRepository.findById(numSkieur).orElse(null);
        Assert.notNull(skieur,"skieur not found");
        Abonnement abonnement = abonnementRepo.findById(numAbon).orElse(null);
        Assert.notNull(abonnement,"abonnement not found");
        //if(skieur!=null && abonnement!=null) {
            skieur.setAbonnement(abonnement);
            return skieurRepository.save(skieur);
        //}
        //return null;
    }
    @Override
    public List<Skieur> getSkieurByAbonnement_TypeAbon(TypeAbonnement typeAbonnement){
        return skieurRepository.findSkieurByAbonnement_TypeAbon(typeAbonnement);
    }
    @Override
    public List<Skieur> findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(TypeCours inscriptions_cours_typeCours, Support inscriptions_cours_support, Couleur pistes_couleur) {
        return skieurRepository.findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(inscriptions_cours_typeCours, inscriptions_cours_support, pistes_couleur);
    }

    @Override
    public List<Skieur> findByMoniteurNameAndSupportTypeJPQL(Support support, String nom) {
        return skieurRepository.findByMoniteurNameAndSupportTypeJPQL(support,nom);
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur) {
        Assert.notNull(skieur.getAbonnement(),"Abonnement must be entered!!!"); //vérifier si l'objet abonn existe
        Assert.notNull(skieur.getInscriptions(),"Inscription must be entered!!!!");
        Set<Inscription> inscriptions=skieur.getInscriptions();
        inscriptions.forEach(inscription -> {   //nparcouri liste taa inscrip w netfaked ken kol inscri aandha cours
            Assert.notNull(inscription.getCours().getNumCours(),"Cours must be entered!!!");
            Cours cours= coursRepository.findById(inscription.getCours().getNumCours()).orElse(null);
            Assert.notNull(cours,"No cours found with this id!!!");
            inscription.setCours(cours); //inscription aandou cours barka donc l inscrip houa li bech ygéri l relation et il va affecter inscrip lel cours
            //taw ki bech ntestiw , exception handler
        });
        skieurRepository.saveAndFlush(skieur); //ken bech nhotha dekhel l for mch bech ysajel les controles de saisie donc nhotha l bara w naawed naamel for lel skieur
        skieur.getInscriptions().forEach(inscription ->{
            inscription.setSkieur(skieur);
            inscriptionRepository.saveAndFlush(inscription);
        });
        return skieur;
    }

}
