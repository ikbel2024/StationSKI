package tn.esprit.stationski.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.*;
import tn.esprit.stationski.repositories.*;

import java.util.List;

@Service
public class AllServicesImp implements  IAllServices {

    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository ;
    @Autowired
    private SkieurRepository skieurRepository;
    @Autowired
    private AbonnementRepository abonnementRepository;
    @Autowired
    private MoniteurRepository moniteurRepository;
    @Autowired
    private PisteRepository pisteRepository;


    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste  retrievePiste(Long numPiste) {
        return  pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public List<Cours> retrieveAllCourses() {
        return coursRepository.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepository.findById(numCours).orElse(null);
    }

    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur).orElse(null);
    }

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public void removeSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);

    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }

    @Override
    public List<Abonnement> retrieveAllAbonnement() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public void removeAbonnement(Long numAbonnement) {
        abonnementRepository.deleteById(numAbonnement);

    }

    @Override
    public Abonnement retrieveAbonnement(Long numAbonnement) {
        return abonnementRepository.findById(numAbonnement).orElse(null);
    }

    @Override
    public List<Inscription> retrieveAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public void removeInscription(Long numInscription) {
        inscriptionRepository.deleteById(numInscription);

    }

    @Override
    public Inscription retrieveInscription(Long numInscription) {
        return inscriptionRepository.findById(numInscription).orElse(null);
    }
}
