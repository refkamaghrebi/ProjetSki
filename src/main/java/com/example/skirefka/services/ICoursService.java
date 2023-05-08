package com.example.skirefka.services;

import com.example.skirefka.entities.Cours;
 import java.util.List;
public interface ICoursService  {
    List<Cours> retrieveAllCourses();
    Cours addCours(Cours cours);
    Cours updateCours (Cours cours);
    Cours retrieveCours (Long numCours);
    void removeCours (Long numCours);
}
