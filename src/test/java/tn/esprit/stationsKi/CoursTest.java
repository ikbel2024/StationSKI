package tn.esprit.stationski;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Inscription;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CoursTest {

    private Cours cours;

    @BeforeEach
    void setUp() {
        cours = new Cours();
        cours.setNomS("Cours de Ski");
        cours.setPrenomS("Introduction au ski");
        cours.setDateNaissance(LocalDate.of(2023, 1, 10));
        cours.setVille("Tunis");

        Set<Inscription> inscriptions = new HashSet<>();
        Inscription inscription1 = new Inscription();
        inscription1.setNom("Participant 1");

        Inscription inscription2 = new Inscription();
        inscription2.setNom("Participant 2");

        inscriptions.add(inscription1);
        inscriptions.add(inscription2);

        cours.setInscriptions(inscriptions);
    }

    @Test
    void testCoursAttributes() {
        assertEquals("Cours de Ski", cours.getNomS());
        assertEquals("Introduction au ski", cours.getPrenomS());
        assertEquals(LocalDate.of(2023, 1, 10), cours.getDateNaissance());
        assertEquals("Tunis", cours.getVille());
    }

    @Test
    void testCoursInscriptions() {
        assertNotNull(cours.getInscriptions());
        assertEquals(2, cours.getInscriptions().size());
    }
}
