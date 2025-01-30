package tn.esprit.stationski.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.services.ICoursService;

import java.util.List;
@RestController
@AllArgsConstructor
public class CoursRestController {
    private ICoursService iCoursService;
    @PostMapping("/addCours")
    public Cours addCours(@RequestBody Cours cours) {
        return iCoursService.addCours(cours);
    }
    @PutMapping("updateCours")
    public Cours cours (@RequestBody Cours cours) {
        return iCoursService.updateCours(cours);
    }
    @GetMapping("/getAllCours")
    public List<Cours> getAllCours() {
        return iCoursService.retrieveAllCours();
    }

    @GetMapping("/getCoursByID/{idC}")
    public Cours getCoursByID(@PathVariable Long idC) {
        return iCoursService.retrieveCoursById(idC);
    }
    @DeleteMapping("/deleteCoursById/{idC}")
    public void CoursDelete(@PathVariable Long idC) {
        iCoursService.deleteCoursById(idC);
    }
}
