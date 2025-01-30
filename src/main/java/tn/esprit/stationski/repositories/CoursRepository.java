package tn.esprit.stationski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Inscription;

public interface CoursRepository extends JpaRepository<Cours,Long> {
}
