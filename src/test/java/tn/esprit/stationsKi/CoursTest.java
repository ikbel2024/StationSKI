
package tn.esprit.stationski;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.TypeCours;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CoursTest {

    private Cours cours;

    @BeforeEach
    void setUp() {
        cours = new Cours();
        cours.setNiveau(3);
        cours.setPrix(250.0f);
        cours.setCreneau(4);
        cours.setTypeC(TypeCours.PARTUCULIER);  // Utilisation de l'énumération existante
    }

    @Test
    void testCoursNotNull() {
        assertNotNull(cours, "L'objet 'cours' ne doit pas être null");
    }

    @Test
    void testCoursAttributes() {
        assertEquals(3, cours.getNiveau(), "Le niveau doit être 3");
        assertEquals(250.0f, cours.getPrix(), "Le prix doit être 250.0");
        assertEquals(4, cours.getCreneau(), "Le créneau doit être 4");
        assertEquals(TypeCours.PARTUCULIER, cours.getTypeC(), "Le type du cours doit être PARTUCULIER");
    }
}

