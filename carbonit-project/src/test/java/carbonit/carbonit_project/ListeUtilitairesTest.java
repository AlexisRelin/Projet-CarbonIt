package carbonit.carbonit_project;

import carbonit.carbonit_project.business.model.bo.AventurierBO;
import carbonit.carbonit_project.business.model.bo.CarteBO;
import carbonit.carbonit_project.business.model.bo.MontagneBO;
import carbonit.carbonit_project.business.model.bo.TresorsBO;
import carbonit.carbonit_project.constantes.Constantes;
import carbonit.carbonit_project.utils.ListesUtilitaires;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Tests unitaires de la classe {@link ListesUtilitaires}
 * */
public class ListeUtilitairesTest {

  private static AventurierBO aventurier1 = new AventurierBO("Lara", 1, 1, Constantes.SUD, "AADADAGGA");
  private static AventurierBO aventurier2 = new AventurierBO("Paul", 1, 2, Constantes.SUD, "AADADAGGA");
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
  public void test_getNombrePatternListeAventurierMax(){

    ListesUtilitaires listes = ListesUtilitaires.getInstance(listeMontagnes, listeAventuriers,
            listeTresors, listeCartes);
    int actual = listes.getNombrePatternListeAventurierMax(listeAventuriers);
    int expected = 9;
    assertEquals(expected, actual);

  }

  @Test
  public void test_montagneExisteIci() {
    ListesUtilitaires listes = ListesUtilitaires.getInstance(listeMontagnes, listeAventuriers,
            listeTresors, listeCartes);

    Boolean actual = listes.montagneExisteIci(2, 1);
    Boolean expected = true;
    assertEquals(expected, actual);

    Boolean actual2 = listes.montagneExisteIci(2, 2);
    Boolean expected2 = false;
    assertEquals(expected2, actual2);
  }

  @Test
  public void test_aventurierExisteIci() {
    ListesUtilitaires listes = ListesUtilitaires.getInstance(listeMontagnes, listeAventuriers,
            listeTresors, listeCartes);

    // Aventurier
    Boolean actual = listes.aventurierExisteIci(1,1,"Tom");
    Boolean expected = true;
    assertEquals(expected, actual);

    // pas d'aventurier
    Boolean actual2 = listes.aventurierExisteIci(1,3,"Tom");
    Boolean expected2 = false;
    assertEquals(expected2, actual2);

  }

  @Test
  public void test_prendTresorSiExisteIci() {
    ListesUtilitaires listes = ListesUtilitaires.getInstance(listeMontagnes, listeAventuriers,
            listeTresors, listeCartes);

    // Trésor présent
    Boolean actual = listes.prendTresorSiExisteIci(1,3);
    Boolean expected = true;
    assertEquals(expected, actual);

    // Trésor non présent
    Boolean actual2 = listes.prendTresorSiExisteIci(2,3);
    Boolean expected2 = false;
    assertEquals(expected2, actual2);
  }
}

