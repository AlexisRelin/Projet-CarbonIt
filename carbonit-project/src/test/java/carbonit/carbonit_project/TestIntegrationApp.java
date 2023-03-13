package carbonit.carbonit_project;

import carbonit.carbonit_project.constantes.Constantes;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/** Tests d'intégration de l'application */
public class TestIntegrationApp {

    @Test
    public void testIntegration_ConflitAventurierTresor() throws IOException {

        String[] args = {"FichierTestIntegration1.txt"};
        App.main(args);

        Path pathFichierActual = Paths.get(Constantes.PATH_DOSSIER_SORTIE + "MatriceSortie.txt");
        Path pathFichierExpected = Paths.get(Constantes.PATH_DOSSIER_SORTIE +
                "FichierTestIntegrationExpected1.txt");

        byte[] fileActual = Files.readAllBytes(pathFichierActual);
        byte[] fileExpected = Files.readAllBytes(pathFichierExpected);

        // Test avec un conflit d'aventurier, sortie de carte et un trésor qui devient vide
        assertArrayEquals(fileActual, fileExpected);
    }

    @Test
    public void testIntegration_ComplexeCommentaire() throws IOException {

        String[] args = {"FichierTestIntegration2.txt"};
        App.main(args);

        Path pathFichierActual = Paths.get(Constantes.PATH_DOSSIER_SORTIE + "MatriceSortie.txt");
        Path pathFichierExpected = Paths.get(Constantes.PATH_DOSSIER_SORTIE +
                "FichierTestIntegrationExpected2.txt");

        byte[] fileActual = Files.readAllBytes(pathFichierActual);
        byte[] fileExpected = Files.readAllBytes(pathFichierExpected);

        // Test avec une grande carte et des commentaires dans le fichier d'entrée
        assertArrayEquals(fileActual, fileExpected);
    }
}
