package com.example.skirefka.services;
import com.example.skirefka.entities.Piste;
import com.example.skirefka.entities.Skieur;
import com.example.skirefka.entities.*;
import com.example.skirefka.entities.TypeAbonnement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);

    void removeSkieur (Long numSkieur);
    Optional<Skieur> retrieveSkieur (Long numSkieur);
    Skieur updateSkieur (Skieur Skieur);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    Skieur AssignSkierToSubscription(Long numSkieur, Long numAbon);

    List<Skieur> getSkieurByAbonnement_TypeAbon(TypeAbonnement typeAbonnement);

    List<Skieur> findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(TypeCours inscriptions_cours_typeCours, Support inscriptions_cours_support, Couleur pistes_couleur);
    List<Skieur> findByMoniteurNameAndSupportTypeJPQL(@Param("support") Support support, @Param("nom") String nom);
    Skieur addSkierAndAssignToCourse(Skieur skieur);
}
