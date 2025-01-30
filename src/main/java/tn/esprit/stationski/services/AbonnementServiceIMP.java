package tn.esprit.stationski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.TypeAbonnement;
import tn.esprit.stationski.repositories.AbonnementRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AbonnementServiceIMP implements IAbonnementService{
    private AbonnementRepository abonnementRepository;
    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public List<Abonnement> retrieveAllAbonnements() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement retrieveAbonnementById(long idA) {
        return abonnementRepository.findById(idA).orElse(null);
    }

    @Override
    public void deleteAbonnementById(long idA) {
        abonnementRepository.deleteById(idA);
    }

    @Override
    public List<Abonnement> getAbonnementByType(TypeAbonnement typeAbonnement) {
        return abonnementRepository.findByTypeAbonOrderByDateDebutAsc(typeAbonnement);
    }

    @Override
    public List<Abonnement> getAbonnementByDate(LocalDate dateDebut, LocalDate dateFin) {
        return abonnementRepository.findByDateDebutBetween(dateDebut,dateFin);
    }
}
