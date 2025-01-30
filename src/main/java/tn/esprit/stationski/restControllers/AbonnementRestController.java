package tn.esprit.stationski.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.Inscription;
import tn.esprit.stationski.entities.TypeAbonnement;
import tn.esprit.stationski.services.IAbonnementService;
import tn.esprit.stationski.services.IInscriptionService;

import java.time.LocalDate;
import java.util.List;
@RestController
@AllArgsConstructor
public class AbonnementRestController {
    private IAbonnementService iAbonnementService;
    @PostMapping("/AddAbonnement")
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement) {
        return iAbonnementService.addAbonnement(abonnement);
    }
    @PutMapping("/updateAbonnement")
    public Abonnement updateAbonnement(@RequestBody Abonnement abonnement) {
        return iAbonnementService.updateAbonnement(abonnement);
    }
    @GetMapping("/getAllAbonnement")
    public List<Abonnement> retrieveAllAbonnement(){
        return iAbonnementService.retrieveAllAbonnements();

    }
    @GetMapping("/getAbonnementByID/{idA}")
    public Abonnement retrieveAbonnementByID(@PathVariable long idA){
        return iAbonnementService.retrieveAbonnementById(idA);
    }

    @DeleteMapping("/deleteAbonnementbyID/{idA}")
    public void deleteAbonnementbyID(@PathVariable int idA) {
         iAbonnementService.deleteAbonnementById(idA);
    }

    @GetMapping("/getAbonnementByType/{typeAbonnement}")
    public List<Abonnement> getAbonnementByType( @PathVariable TypeAbonnement typeAbonnement){
        return iAbonnementService.getAbonnementByType(typeAbonnement);
    }
    @GetMapping("/getAbonnementByDate/{dateDebut}/{dateFin}")
    public List<Abonnement> getAbonnementByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateDebut, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFin){
        return iAbonnementService.getAbonnementByDate(dateDebut, dateFin);
    }
}
