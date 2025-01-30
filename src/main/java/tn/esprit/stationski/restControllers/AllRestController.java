package tn.esprit.stationski.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.stationski.entities.*;
import tn.esprit.stationski.repositories.AbonnementRepository;
import tn.esprit.stationski.services.IAllServices;

import java.util.List;

@RestController
@AllArgsConstructor
public class AllRestController {

    @Autowired
    private IAllServices iAllServices;


    public List<Piste> retrieveAllPistes() {
        return iAllServices.retrieveAllPistes();
    }

    @PostMapping("/addPiste")
    public Piste addPiste(Piste piste) {
        return iAllServices.addPiste(piste);
    }

    public Piste updatePiste(Piste piste) {
        return iAllServices.updatePiste(piste);
    }

    public Piste  retrievePiste(Long numPiste) {
        return  iAllServices.retrievePiste(numPiste);
    }

    public List<Cours> retrieveAllCourses() {
        return iAllServices.retrieveAllCourses();
    }

    @PostMapping("/addCours")
    public Cours addCours(Cours cours) {
        return iAllServices.addCours(cours);
    }

    public Cours updateCours(Cours cours) {
        return iAllServices.updateCours(cours);
    }

    public Cours retrieveCours(Long numCours) {
        return iAllServices.retrieveCours(numCours);
    }

    public List<Moniteur> retrieveAllMoniteurs() {
        return iAllServices.retrieveAllMoniteurs();
    }

    @PostMapping("/addMoniteur")
    public Moniteur addMoniteur(Moniteur moniteur) {
        return iAllServices.addMoniteur(moniteur);
    }

    public Moniteur updateMoniteur(Moniteur moniteur) {
        return iAllServices.updateMoniteur(moniteur);
    }

    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return iAllServices.retrieveMoniteur(numMoniteur);
    }

    public List<Skieur> retrieveAllSkieurs() {
        return iAllServices.retrieveAllSkieurs();
    }

    @PostMapping("/addSkieur")
    public Skieur addSkieur(Skieur skieur) {
        return iAllServices.addSkieur(skieur);
    }

    public void removeSkieur(Long numSkieur) {
        iAllServices.removeSkieur(numSkieur);

    }

    public Skieur retrieveSkieur(Long numSkieur) {
        return iAllServices.retrieveSkieur(numSkieur);
    }

    public List<Abonnement> retrieveAllAbonnement() {
        return iAllServices.retrieveAllAbonnement();
    }

    @PostMapping("/addAbonnement")
    public Abonnement addAbonnement(Abonnement abonnement) {
        return iAllServices.addAbonnement(abonnement);
    }

    public void removeAbonnement(Long numAbonnement) {
        iAllServices.removeAbonnement(numAbonnement);

    }

    public Abonnement retrieveAbonnement(Long numAbonnement) {
        return iAllServices.retrieveAbonnement(numAbonnement);
    }

    public List<Inscription> retrieveAllInscriptions() {
        return iAllServices.retrieveAllInscriptions();
    }

    @PostMapping("/addInscription")
    public Inscription addInscription(Inscription inscription) {
        return iAllServices.addInscription(inscription);
    }

    public void removeInscription(Long numInscription) {
        iAllServices.removeInscription(numInscription);

    }

    public Inscription retrieveInscription(Long numInscription) {
        return iAllServices.retrieveInscription(numInscription);
    }

}
