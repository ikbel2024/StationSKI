package tn.esprit.stationski.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Piste;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.entities.TypeAbonnement;
import tn.esprit.stationski.repositories.PisteRepository;
import tn.esprit.stationski.repositories.SkieurRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class SkieurServiceIMP implements ISkieurService{
    private SkieurRepository skieurRepository;
    private PisteRepository pisteRepository;
    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public List<Skieur> retrieveAllSkieur() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur retrieveSkieurById(long idSKI) {
        return skieurRepository.findById(idSKI).orElse(null);
    }

    @Override
    public void deleteSkieurById(long idSKI) {
        skieurRepository.deleteById(idSKI);

    }

    @Override
    public Skieur assignSkieurToPiste(long idSK, long idPiste) {
        Skieur skieur = skieurRepository.findById(idSK).orElse(null);
        Piste piste = pisteRepository.findById(idPiste).orElse(null);
        try{
        skieur.getPistes().add(piste);

        }
        catch(NullPointerException e){
            e.printStackTrace();
            List<Piste> pistes = new ArrayList<>();
            pistes.add(piste);
            skieur.setPistes(pistes);
        }
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur getSkieurByNom(String nomSK) {
        return skieurRepository.findByNomSk(nomSK);
    }

    @Override
    public Skieur getSkieurByPrenom(String prenomSK) {
        return skieurRepository.findByPrenomSk(prenomSK);
    }

    @Override
    public List<Skieur> getSkieurByDateNaissance(LocalDate dateNaissance) {
        return skieurRepository.findByDateNaissIsGreaterThan(dateNaissance);
    }

    @Override
    public Skieur getSKieurByNomAndPrenom(String nomSK, String prenomSK) {
        return skieurRepository.findByNomSkAndPrenomSk(nomSK,prenomSK);
    }

    @Override
    public List<Skieur> getSkieurByTypeabon(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnement_TypeAbon(typeAbonnement);
    }

    @Override
    public List<Skieur> retieveSkieurByVille(String villeSK) {
        return skieurRepository.retrieveSkieurByVille(villeSK);
    }
    /*@Scheduled(fixedRate = 30000)
    public void fixedRateMethod(){
       log.info("Methode with fixed rate");
    }*/
    /*@Scheduled(fixedDelay = 30000)
    public void fixedDelayMethod(){
        log.info("fixedDelayMethod");
    }*/
    @Scheduled(cron ="0 47 19 31 10 *")
    public void fixedCronMethod(){
        log.info("Method with fixed cron method");
    }
}
