package tn.esprit.stationski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Inscription;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.entities.Support;
import tn.esprit.stationski.repositories.CoursRepository;
import tn.esprit.stationski.repositories.InscriptionRepository;
import tn.esprit.stationski.repositories.SkieurRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class InscriptionServiceImpl implements IInscriptionService{
    private CoursRepository coursRepository;
    private SkieurRepository skieurRepository;
    private InscriptionRepository inscriptionRepository;
    @Override
    public Inscription addInscription(Inscription inscription) {

        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public List<Inscription> retrieveAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription retrieveInscriptionById(long idI) {
        return inscriptionRepository.findById(idI).orElse(null);
    }

    @Override
    public void deleteInscriptionById(long idI) {
    inscriptionRepository.deleteById(idI);
    }

    @Override
    public Inscription AddInscriptionAndAssignToSkieur(Inscription inscription, Long idSK) {
        Skieur skieur = skieurRepository.findById(idSK).orElse(null);
        inscription.setSkieur(skieur);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription AddCoursAndAssignToCours(Inscription inscription, Long idC) {
        Cours cours = coursRepository.findById(idC).orElse(null);
        inscription.setCours(cours);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public List<Integer> numWeeksCoursDfInstructorBySupport(Long numM, Support support) {
        return inscriptionRepository.numWeeksCoursDfInstructorBySupport(numM,support);
    }


}
