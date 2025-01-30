package tn.esprit.stationski.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.repositories.MoniteurRepository;
import tn.esprit.stationski.services.IMoniteurservice;

@AllArgsConstructor
@RestController
public class MoniteurRestController {
    private IMoniteurservice iMoniteurservice;

    @PostMapping("/addMoniteurAndAssignToCours/{numC}")
    public Moniteur addMoniteurAndAssignToCours(@RequestBody Moniteur moniteur, @PathVariable long numC){
        return iMoniteurservice.addMoniteurAndAssignToCours(moniteur,numC);
    }

    }
