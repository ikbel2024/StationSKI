package tn.esprit.stationski;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.TypeCours;
import tn.esprit.stationski.entities.Support;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CoursTest {

    private Cours cours;

    @BeforeEach
    void setUp() {
        cours = new Cours();
        cours.setNumC(1L);
        cours.setNiveau(2);
        cours.setTypeC(TypeCours.COLLECTIF);
        cours.setSupport(Support.SKI);
        cours.setPrix(150.0f);
        cours.setCreneau(3);
    }

    @Test
    public void testCoursAttributes() {
        assertEquals(1L, cours.getNumC());
        assertEquals(2, cours.getNiveau());
        assertEquals(TypeCours.COLLECTIF, cours.getTypeC());
        assertEquals(Support.SKI, cours.getSupport());
        assertEquals(150.0f, cours.getPrix());
        assertEquals(3, cours.getCreneau());
    }

    @Test
    public void testModificationAttributes() {
        cours.setNiveau(3);
        cours.setPrix(200.0f);

        assertEquals(3, cours.getNiveau());
        assertEquals(200.0f, cours.getPrix());
    }
}


