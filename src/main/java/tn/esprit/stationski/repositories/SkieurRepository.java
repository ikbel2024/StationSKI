package tn.esprit.stationski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur, Long> {
    public Skieur findByNomSk(String nomSK);
    public Skieur findByPrenomSk(String prenomSK);
    public List<Skieur> findByDateNaissIsGreaterThan(LocalDate datenaissance);
    public Skieur findByNomSkAndPrenomSk(String nomsk, String prenomSK);

    public List<Skieur> findByAbonnement_TypeAbon(TypeAbonnement typeAbonnement);

    @Query("select s  from Skieur s where s.ville=:ville")
    public List<Skieur>retrieveSkieurByVille(@Param("ville") String ville);

}
