

package tn.esprit.stationski.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.repositories.CoursRepository;

@ExtendWith(MockitoExtension.class)
public class CoursTest {

    @Mock
    private CoursRepository coursRepository;

    @InjectMocks
    private CoursServiceIMP coursService;

    private Cours cours;

    @BeforeEach
    void setUp() {
        cours = new Cours();
        cours.setNiveau(3);
        cours.setPrix(250.0f);
        cours.setCreneau(4);
    }

    @Test
    void testAddCours() {
        when(coursRepository.save(any(Cours.class))).thenReturn(cours);
        Cours savedCours = coursService.addCours(cours);
        assertNotNull(savedCours);
        assertEquals(3, savedCours.getNiveau());
    }

    @Test
    void testUpdateCours() {
        when(coursRepository.save(any(Cours.class))).thenReturn(cours);
        Cours updatedCours = coursService.updateCours(cours);
        assertNotNull(updatedCours);
        assertEquals(250.0f, updatedCours.getPrix());
    }

    @Test
    void testRetrieveAllCours() {
        List<Cours> coursList = Arrays.asList(cours, new Cours());
        when(coursRepository.findAll()).thenReturn(coursList);
        List<Cours> result = coursService.retrieveAllCours();
        assertEquals(2, result.size());
    }

    @Test
    void testRetrieveCoursById() {
        when(coursRepository.findById(anyLong())).thenReturn(Optional.of(cours));
        Cours foundCours = coursService.retrieveCoursById(1L);
        assertNotNull(foundCours);
        assertEquals(4, foundCours.getCreneau());
    }

    @Test
    void testDeleteCoursById() {
        doNothing().when(coursRepository).deleteById(anyLong());
        coursService.deleteCoursById(1L);
        verify(coursRepository, times(1)).deleteById(1L);
    }
}
