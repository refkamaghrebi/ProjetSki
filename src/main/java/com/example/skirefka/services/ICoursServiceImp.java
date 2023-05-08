package com.example.skirefka.services;

import com.example.skirefka.entities.Cours;
import com.example.skirefka.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICoursServiceImp implements ICoursService {

    @Autowired
    CoursRepository coursRepository;

    @Override
    public List<Cours> retrieveAllCourses() {

        return coursRepository.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {

        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {

        return coursRepository.findById(numCours).orElse(null);
    }

    @Override
    public void removeCours(Long numCours) {
        coursRepository.deleteById(numCours);
    }
}
