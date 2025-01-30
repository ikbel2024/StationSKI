package tn.esprit.stationski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.repositories.CoursRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class CoursServiceIMP implements ICoursService {
    private CoursRepository coursRepository;
    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public List<Cours> retrieveAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public Cours retrieveCoursById(long idC) {
        return coursRepository.findById(idC).orElse(null);
    }

    @Override
    public void deleteCoursById(long idC) {
    coursRepository.deleteById(idC);
    }
}
