package carbonit.carbonit_project;

import carbonit.carbonit_project.business.model.bo.AventurierBO;
import carbonit.carbonit_project.business.model.bo.CarteBO;
import carbonit.carbonit_project.business.model.bo.MontagneBO;
import carbonit.carbonit_project.business.model.bo.TresorsBO;
import carbonit.carbonit_project.constantes.Constantes;
import carbonit.carbonit_project.mapper.FichierEntreeMapper;
import carbonit.carbonit_project.utils.ListesUtilitaires;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Tests unitaires de la classe {@link FichierEntreeMapper}*/
public class FichierEntreeMapperTest {

    private static AventurierBO aventurier1 = new AventurierBO("Lara", 1, 1, Constantes.SUD, "AADADAGGA");
    private static AventurierBO aventurier2 = new AventurierBO("Paul", 1, 3, Constantes.SUD, "AADADAGGA");
    private static MontagneBO montagne1 = new MontagneBO(1, 0);
    private static MontagneBO montagne2 = new MontagneBO(2, 1);
    private static TresorsBO tresors1 = new TresorsBO(0, 3, 2);
    private static TresorsBO tresors2 = new TresorsBO(1, 3, 3);
    private static CarteBO carte = new CarteBO(3, 4);

    private static ArrayList<MontagneBO> listeMontagnes = new ArrayList<>(Arrays.asList(montagne1, montagne2));
    private static ArrayList<AventurierBO> listeAventuriers = new ArrayList<>(Arrays.asList(aventurier1, aventurier2));
    private static ArrayList<TresorsBO>  listeTresors = new ArrayList<>(Arrays.asList(tresors1, tresors2));
    private static ArrayList<CarteBO> listeCartes = new ArrayList<>(Arrays.asList(carte));


    @Test
    public void test_mapFileToListes(){

        String input = "C - 3 - 4\n" +
                "M - 1 - 0\n" +
                "M - 2 - 1\n" +
                "T - 0 - 3 - 2\n" +
                "T - 1 - 3 - 3\n" +
                "A - Lara - 1 - 1 - S - AADADAGGA\n" +
                "A - Paul - 1 - 2 - S - AADADAGGA";

        Scanner scanner = new Scanner(input);
        ListesUtilitaires listesActual = FichierEntreeMapper.mapFileToListes(scanner);

        // Aventurier correspond
        assertEquals(aventurier1.toString(), listesActual.getListeAventuriers().get(0).toString());
        // Montagne correspond
        assertEquals(montagne1.toString(), listesActual.getListeMontagnes().get(0).toString());
        // Carte correspond
        assertEquals(carte.toString(), listesActual.getListeCartes().get(0).toString());
    }
}
