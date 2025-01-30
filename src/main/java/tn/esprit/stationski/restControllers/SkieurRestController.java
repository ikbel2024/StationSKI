package tn.esprit.stationski.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.entities.TypeAbonnement;
import tn.esprit.stationski.services.ISkieurService;

import java.time.LocalDate;
import java.util.List;
@RestController
@AllArgsConstructor
public class SkieurRestController {
    private ISkieurService iSkieurService;
    @PostMapping("/addSkieur")
    public Skieur addSkieur(@RequestBody Skieur skieur) {
        return iSkieurService.addSkieur(skieur);

    }

    @PutMapping("/updateSkieur")
    public Skieur updateSkieur(@RequestBody Skieur skieur) {
        return iSkieurService.updateSkieur(skieur);
    }

    @GetMapping("/getAllSkieur")
    public List<Skieur> retrieveAllSkieur(){
        return iSkieurService.retrieveAllSkieur();

    }
    @GetMapping("/getSkieurByID/{idSKI}")
    public Skieur retrieveSkieurByID(@PathVariable Long idSKI){
        return iSkieurService.retrieveSkieurById(idSKI);
    }
    @DeleteMapping("/deleteSkieurById/{idSKI}")
    public void deleteSkieurByID(@PathVariable Long idSKI) {
        iSkieurService.deleteSkieurById(idSKI);
    }

    @PostMapping("/assignSkieurToPiste/{idSK}/{idPiste}")
    public Skieur assignSkieurToPiste(@PathVariable long idSK, @PathVariable long idPiste) {
        return iSkieurService.assignSkieurToPiste(idSK, idPiste);


    }

    @GetMapping("/getSkieurByNom/{nomSK}")
    public Skieur getSkieurByNom(@PathVariable String nomSK)
    {
        return iSkieurService.getSkieurByNom(nomSK);

    }
    @GetMapping("/getSkieurByPrenom/{prenomSK}")
    public Skieur getSkieurByPrenom(@PathVariable String prenomSK)
    {
        return iSkieurService.getSkieurByPrenom(prenomSK);
    }
    @GetMapping("/getSkieurByDateNaissance/{dateNaissance}")
    public List<Skieur> getSkieurByDateNaissance(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateNaissance)
    {
        return iSkieurService.getSkieurByDateNaissance( dateNaissance );
    }
    @GetMapping("/getSKieurByNomAndPrenom/{nomSK}/{prenomSK}")
    public Skieur getSKieurByNomAndPrenom(@PathVariable String nomSK, @PathVariable String prenomSK)
    {
        return iSkieurService.getSKieurByNomAndPrenom(nomSK,prenomSK);
    }
    @GetMapping("/getSkieurByTypeabon/{typeAbonnement}")
    public List<Skieur> getSkieurByTypeabon( @PathVariable TypeAbonnement typeAbonnement){
        return iSkieurService.getSkieurByTypeabon(typeAbonnement);
    }
    @GetMapping("/retieveSkieurByVille/{villeSK}")
    public List<Skieur> retieveSkieurByVille(@PathVariable String villeSK){
        return iSkieurService.retieveSkieurByVille(villeSK);
    }
}
