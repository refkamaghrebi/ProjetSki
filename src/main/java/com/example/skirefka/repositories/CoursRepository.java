package com.example.skirefka.repositories;

import com.example.skirefka.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long>{
    @Query(value = "SELECT * " +
            "FROM cours c" +
            "ORDER BY (SELECT COUNT * FROM inscription i WHERE i.cours_num_cours = c.num_cours)", nativeQuery = true)
    List<Cours> getAllOrderByInscriptionNumberSQL();

    @Query(value = "SELECT c FROM Cours c ORDER BY c.inscriptions.size")
    List<Cours> getAllOrderByInscriptionNumberJPQL();

}
