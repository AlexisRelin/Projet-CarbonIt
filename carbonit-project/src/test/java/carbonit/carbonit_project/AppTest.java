package carbonit.carbonit_project;

import carbonit.carbonit_project.business.model.bo.AventurierBO;
import carbonit.carbonit_project.constantes.Constantes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires de l'application
 * */
public class AppTest {

  @Test
  public void testGetOrientationByDirection(){
    AventurierBO aventurier1 = new AventurierBO("Paul", 1, 1, Constantes.NORD, "ADDAAG");
    String orientation = aventurier1.getOrientationByDirection(Constantes.DROITE);
    assertEquals(orientation, Constantes.EST);

    AventurierBO aventurier2 = new AventurierBO("Paul", 1, 1, Constantes.OUEST, "ADDAAG");
    orientation = aventurier2.getOrientationByDirection(Constantes.DROITE);
    assertEquals(orientation, Constantes.NORD);

    AventurierBO aventurier3 = new AventurierBO("Paul", 1, 1, Constantes.SUD, "ADDAAG");
    orientation = aventurier3.getOrientationByDirection(Constantes.GAUCHE);
    assertEquals(orientation, Constantes.EST);
  }
  
}

