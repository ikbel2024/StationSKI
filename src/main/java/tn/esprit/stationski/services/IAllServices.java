package tn.esprit.stationski.services;

import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.*;

import java.util.List;

@Service
public interface IAllServices {

    List<Piste> retrieveAllPistes();
    public Piste addPiste(Piste piste);
    Piste updatePiste (Piste piste);
    Piste retrievePiste (Long numPiste);

    List<Cours> retrieveAllCourses();
    Cours addCours(Cours cours);
    Cours updateCours (Cours cours);
    Cours retrieveCours (Long numCours);

    List<Moniteur> retrieveAllMoniteurs();
    Moniteur addMoniteur(Moniteur moniteur);
    Moniteur updateMoniteur (Moniteur moniteur);
    Moniteur retrieveMoniteur (Long numMoniteur);

    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);
    void removeSkieur (Long numSkieur);
    Skieur retrieveSkieur (Long numSkieur);


    List<Abonnement> retrieveAllAbonnement();
    Abonnement addAbonnement(Abonnement abonnement);
    void removeAbonnement (Long numAbonnement);
    Abonnement retrieveAbonnement (Long numAbonnement);

    List<Inscription> retrieveAllInscriptions();
    Inscription addInscription (Inscription inscription);
    void removeInscription (Long numInscription);
    Inscription retrieveInscription (Long numInscription );

}
