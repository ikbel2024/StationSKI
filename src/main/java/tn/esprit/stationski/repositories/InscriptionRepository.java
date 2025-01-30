package tn.esprit.stationski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.stationski.entities.Inscription;
import tn.esprit.stationski.entities.Support;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
    @Query("select n.numSemaine from Inscription  n " +
    "Join Moniteur m on n.cours member of m.cours " +
    "where m.numM=:numM" +
    " AND n.cours.support=:support ")
    public List<Integer> numWeeksCoursDfInstructorBySupport(@Param("numM") Long numM, @Param("support") Support support);
}
