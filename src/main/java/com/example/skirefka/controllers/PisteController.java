package com.example.skirefka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.skirefka.entities.Piste;
import com.example.skirefka.entities.Skieur;
import com.example.skirefka.services.IPisteService;
import com.example.skirefka.services.ISkieurService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("piste")
public class PisteController {

    @Autowired
    IPisteService iPisteService;
    @GetMapping
    public List<Piste> getAll(){
        return iPisteService.retrieveAllPistes();

    }

    @GetMapping("{numPiste}")

    public Optional<Piste> retrievePiste(@PathVariable Long numPiste) {

        return  iPisteService.retrievePiste(numPiste);

    }
    @PostMapping

    public Piste addPiste(@RequestBody Piste piste){

        return iPisteService.addPiste(piste);
    }

    @DeleteMapping("{numpiste}")
    public void removePiste(@PathVariable Long numpiste){

        iPisteService.removePiste(numpiste);
    }
    @PutMapping
    public Piste updatePiste(@RequestBody Piste Piste) {

        return  iPisteService.updatePiste(Piste);

    }

}
