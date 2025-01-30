package tn.esprit.stationski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.repositories.CoursRepository;
import tn.esprit.stationski.repositories.MoniteurRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class MoniteurServiceIMP implements IMoniteurservice {
    private MoniteurRepository moniteurRepository;
    private CoursRepository  coursRepository;
    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public List<Moniteur> retrieveAllMoniteur() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur retrieveMoniteurById(long idM) {
        return moniteurRepository.findById(idM).orElse(null);
    }

    @Override
    public void deleteMoniteurById(long idM) {
    moniteurRepository.deleteById(idM);
    }

    @Override
    public Moniteur addMoniteurAndAssignToCours(Moniteur moniteur, long numC) {
        Cours cours = coursRepository.findById(numC).orElse(null);
        List<Cours> coursList = new ArrayList<>();
        coursList.add(cours);
        moniteur.setCours(coursList);
        return moniteurRepository.save(moniteur);
    }
}
