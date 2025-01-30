package tn.esprit.stationski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    public List<Abonnement> findByTypeAbonOrderByDateDebutAsc(TypeAbonnement typeAbonnement);

    public List<Abonnement> findByDateDebutBetween(LocalDate dateDebut, LocalDate dateFin);
}
