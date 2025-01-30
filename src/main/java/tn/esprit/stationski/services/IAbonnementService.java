package tn.esprit.stationski.services;

import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.Inscription;
import tn.esprit.stationski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;

public interface IAbonnementService {
    public Abonnement addAbonnement(Abonnement abonnement);
    public Abonnement updateAbonnement(Abonnement abonnement);
    List<Abonnement> retrieveAllAbonnements();
    public Abonnement retrieveAbonnementById(long idA);
    public void deleteAbonnementById(long idA);

    public List<Abonnement> getAbonnementByType(TypeAbonnement typeAbonnement );

    public List<Abonnement> getAbonnementByDate(LocalDate dateDebut, LocalDate dateFin);
}
