package tn.esprit.stationski.services;

import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Inscription;

import java.util.List;

public interface ICoursService  {
    public Cours addCours(Cours cours);
    public Cours updateCours(Cours cours);
    List<Cours> retrieveAllCours();
    public Cours retrieveCoursById(long idC);
    public void deleteCoursById(long idC);
}
