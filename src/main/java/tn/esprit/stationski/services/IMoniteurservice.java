package tn.esprit.stationski.services;

import tn.esprit.stationski.entities.Inscription;
import tn.esprit.stationski.entities.Moniteur;

import java.util.List;

public interface IMoniteurservice  {
    public Moniteur addMoniteur(Moniteur moniteur);
    public Moniteur updateMoniteur(Moniteur moniteur);
    List<Moniteur> retrieveAllMoniteur();
    public Moniteur retrieveMoniteurById(long idM);
    public void deleteMoniteurById(long idM);
    public Moniteur addMoniteurAndAssignToCours(Moniteur moniteur,long numC);
}
