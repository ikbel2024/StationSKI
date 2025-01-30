package tn.esprit.stationski.services;

import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;

public interface ISkieurService {
    public Skieur addSkieur(Skieur skieur);
    public Skieur updateSkieur(Skieur skieur);
    List<Skieur> retrieveAllSkieur();
    public Skieur retrieveSkieurById(long idSKI);
    public void deleteSkieurById(long idSKI);

    public Skieur assignSkieurToPiste(long idSK, long idPiste);

    public Skieur getSkieurByNom(String nomSK);
    public Skieur getSkieurByPrenom(String prenomSK);
    public List<Skieur> getSkieurByDateNaissance(LocalDate dateNaissance);
    public Skieur getSKieurByNomAndPrenom(String nomSK, String prenomSK);

    public List<Skieur> getSkieurByTypeabon(TypeAbonnement typeAbon);

    public List<Skieur> retieveSkieurByVille(String villeSK);

}

