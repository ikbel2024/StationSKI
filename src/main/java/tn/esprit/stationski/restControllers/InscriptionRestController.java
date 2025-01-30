package tn.esprit.stationski.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Inscription;
import tn.esprit.stationski.entities.Support;
import tn.esprit.stationski.services.IInscriptionService;

import java.util.List;

@AllArgsConstructor
@RestController
public class InscriptionRestController {
    private IInscriptionService inscriptionService;
    @PostMapping("/AddInscriptionAndAsignToSkieur/{numSkieur}")
    public Inscription AddInscriptionAndAsignToSkieur(@RequestBody Inscription inscription, @PathVariable Long  numSkieur) {
        return inscriptionService.AddInscriptionAndAssignToSkieur(inscription,numSkieur);
    }
    @PostMapping("/AddCoursAndAssignToCours/{numC}")
    public Inscription AddCoursAndAssignToCours(@RequestBody Inscription inscription, @PathVariable Long  numC) {
        return inscriptionService.AddCoursAndAssignToCours(inscription,numC);
    }
    @GetMapping("/numWeeksCoursDfInstructorBySupport/{numM}/{support}")
    public List<Integer> numWeeksCoursDfInstructorBySupport(@PathVariable Long numM, @PathVariable Support support){
        return  inscriptionService.numWeeksCoursDfInstructorBySupport(numM,support);
    }

}
