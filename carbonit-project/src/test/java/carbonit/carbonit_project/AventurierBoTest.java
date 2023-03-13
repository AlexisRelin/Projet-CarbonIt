package carbonit.carbonit_project;

import carbonit.carbonit_project.business.model.bo.AventurierBO;
import carbonit.carbonit_project.business.model.bo.CarteBO;
import carbonit.carbonit_project.business.model.bo.MontagneBO;
import carbonit.carbonit_project.business.model.bo.TresorsBO;
import carbonit.carbonit_project.constantes.Constantes;
import carbonit.carbonit_project.utils.ListesUtilitaires;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests unitaires de la classe {@link AventurierBO}
 * */
public class AventurierBoTest {

  private static AventurierBO aventurier1 = new AventurierBO("Lara", 1, 1, Constantes.NORD, "AADADAGGA");
  private static AventurierBO aventurier2 = new AventurierBO("Paul", 1, 2, Constantes.OUEST, "AADADAGGA");
  private static AventurierBO aventurier3 = new AventurierBO("Paul", 2, 0, Constantes.SUD, "AADADAGGA");
  private static MontagneBO montagne1 = new MontagneBO(1, 0);
  private static MontagneBO montagne2 = new MontagneBO(2, 1);
  private static TresorsBO tresors1 = new TresorsBO(0, 3, 2);
  private static TresorsBO tresors2 = new TresorsBO(1, 3, 3);
  private static CarteBO carte = new CarteBO(3, 4);

  private static ArrayList<MontagneBO> listeMontagnes = new ArrayList<>(Arrays.asList(montagne1, montagne2));
  private static ArrayList<AventurierBO> listeAventuriers = new ArrayList<>(Arrays.asList(aventurier1,
          aventurier2, aventurier3));
  private static ArrayList<TresorsBO>  listeTresors = new ArrayList<>(Arrays.asList(tresors1, tresors2));
  private static ArrayList<CarteBO> listeCartes = new ArrayList<>(Arrays.asList(carte));


  @Test
  public void test_GetOrientationByDirection_casNominaux(){

    String orientation = aventurier1.getOrientationByDirection(Constantes.DROITE);
    assertEquals(orientation, Constantes.EST);

    orientation = aventurier2.getOrientationByDirection(Constantes.DROITE);
    assertEquals(orientation, Constantes.NORD);

    orientation = aventurier3.getOrientationByDirection(Constantes.GAUCHE);
    assertEquals(orientation, Constantes.EST);
  }

  @Test
  public void test_getNewCasePosition_all(){

    ListesUtilitaires listes = ListesUtilitaires.getInstance(listeMontagnes, listeAventuriers,
            listeTresors, listeCartes);

    // Test blocage Aventurier
    int[] actual = aventurier1.getNewCasePosition(aventurier1.getOrientation(),
            aventurier1.getPositionX(), aventurier1.getPositionY(), Constantes.AVANCE, aventurier1.getNom());
    int[] expected = new int[]{1, 1};
    assertArrayEquals(expected, actual);

    // Test sans blocage
    int[] actual2 = aventurier2.getNewCasePosition(aventurier1.getOrientation(),
            aventurier2.getPositionX(), aventurier2.getPositionY(), Constantes.AVANCE, aventurier2.getNom());
    int[] expected2 = new int[]{1, 2};
    assertArrayEquals(expected2, actual2);

    // Test blocage montagne
    int[] actual3 = aventurier3.getNewCasePosition(aventurier1.getOrientation(),
            aventurier3.getPositionX(), aventurier3.getPositionY(), Constantes.AVANCE, aventurier3.getNom());
    int[] expected3 = new int[]{2, 0};
    assertArrayEquals(expected3, actual3);
  }
}

