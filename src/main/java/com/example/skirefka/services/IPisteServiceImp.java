package com.example.skirefka.services;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.skirefka.entities.Piste;
import com.example.skirefka.repositories.PisteRepository;
import com.example.skirefka.repositories.SkieurRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class IPisteServiceImp implements IPisteService{

    @Autowired
    PisteRepository pisteRepository;
    @Override
    public List<Piste> retrieveAllPistes() {
        return  pisteRepository.findAll();    }

    @Override
    public Piste addPiste(Piste piste) {
         return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Optional<Piste> retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste);
    }

    @Override
    public void removePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }

    @Override
    //@Scheduled(fixedDelay = 60000)
    @Scheduled(fixedRate = 60000 )
    //@Scheduled(cron =  )

    public void test() {
       log.info("************"); //message dans fichier journalisation

    }

}
