package tn.esprit.stationski;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.stationski.entities.Skieur;
import tn.esprit.stationski.repositories.PisteRepository;
import tn.esprit.stationski.repositories.SkieurRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import tn.esprit.stationski.services.SkieurServiceIMP;

@ExtendWith(MockitoExtension.class)
public class SkieurServiceIMPTest {

    @Mock
    private SkieurRepository skieurRepository;

    @Mock
    private PisteRepository pisteRepository;

    @InjectMocks
    private SkieurServiceIMP skieurService;

    private Skieur skieur;

    @BeforeEach
    void setUp() {
        skieur = new Skieur();
        skieur.setNumSK(1L);
        skieur.setNomSk("Dupont");
        skieur.setPrenomSk("Jean");
        skieur.setDateNaiss(LocalDate.of(1995, 5, 20));
    }

    @Test
    void testAddSkieur() {
        when(skieurRepository.save(skieur)).thenReturn(skieur);

        Skieur savedSkieur = skieurService.addSkieur(skieur);

        assertNotNull(savedSkieur);
        assertEquals("Dupont", savedSkieur.getNomSk());
        verify(skieurRepository, times(1)).save(skieur);
    }

    @Test
    void testRetrieveAllSkieur() {
        List<Skieur> skieurs = Arrays.asList(skieur, new Skieur());
        when(skieurRepository.findAll()).thenReturn(skieurs);

        List<Skieur> result = skieurService.retrieveAllSkieur();

        assertEquals(2, result.size());
        verify(skieurRepository, times(1)).findAll();
    }

    @Test
    void testRetrieveSkieurById() {
        when(skieurRepository.findById(1L)).thenReturn(Optional.of(skieur));

        Skieur result = skieurService.retrieveSkieurById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getNumSK());
        verify(skieurRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteSkieurById() {
        doNothing().when(skieurRepository).deleteById(1L);

        skieurService.deleteSkieurById(1L);

        verify(skieurRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetSkieurByNom() {
        when(skieurRepository.findByNomSk("Dupont")).thenReturn(skieur);

        Skieur result = skieurService.getSkieurByNom("Dupont");

        assertNotNull(result);
        assertEquals("Dupont", result.getNomSk());
        verify(skieurRepository, times(1)).findByNomSk("Dupont");
    }
}
