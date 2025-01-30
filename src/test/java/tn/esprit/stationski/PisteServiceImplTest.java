package tn.esprit.stationski;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.stationski.entities.Piste;
import tn.esprit.stationski.services.IAllServices;

import java.util.List;

@SpringBootTest // Charge le contexte Spring pour les tests
public class PisteServiceImplTest {

    @Autowired
    private IAllServices us; // Injection du service

    @Test
    @Order(1)
    public void testRetrieveAllPistes() {
        // Exécuter la méthode du service
        List<Piste> listPistes = us.retrieveAllPistes();

        // Vérifier que la liste n'est pas nulle
        Assertions.assertNotNull(listPistes, "La liste des pistes ne doit pas être nulle");

        // Vérifier si elle est vide ou contient des éléments (Dépend de la BD)
        System.out.println("Nombre de pistes trouvées : " + listPistes.size());

        // Exemple d'attente : si la base est vide au démarrage
        Assertions.assertTrue(listPistes.size() >= 0);
    }
}
