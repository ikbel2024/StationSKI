package tn.esprit.stationski.services;

import tn.esprit.stationski.entities.Inscription;
import tn.esprit.stationski.entities.Support;

import java.util.List;

public interface IInscriptionService {
    public Inscription addInscription(Inscription inscription);
    public Inscription updateInscription(Inscription inscription);
    List<Inscription> retrieveAllInscriptions();
    public Inscription retrieveInscriptionById(long idI);
    public void deleteInscriptionById(long idI);

    public Inscription AddInscriptionAndAssignToSkieur (Inscription inscription, Long idSK);
    public Inscription AddCoursAndAssignToCours(Inscription inscription, Long idC);
    public List<Integer> numWeeksCoursDfInstructorBySupport(Long numM, Support support);
}
