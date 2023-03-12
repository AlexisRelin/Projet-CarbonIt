package carbonit.carbonit_project;

import carbonit.carbonit_project.business.model.bo.AventurierBO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

  @Test
  public void testApp() {
    assertTrue(true);
    App.main(null);
  }

  @Test
  public void testGetOrientationByDirection(){
    AventurierBO aventurier1 = new AventurierBO(1, 1, "NORD", "ADDAAG");
    String direction = "DROITE";
    String orientation = aventurier1.getOrientationByDirection(direction);
    assertEquals(orientation, "EST");

    AventurierBO aventurier2 = new AventurierBO(1, 1, "OUEST", "ADDAAG");
    direction = "DROITE";
    orientation = aventurier2.getOrientationByDirection(direction);
    assertEquals(orientation, "SUD");

    AventurierBO aventurier3 = new AventurierBO(1, 1, "SUD", "ADDAAG");
    direction = "GAUCHE";
    orientation = aventurier3.getOrientationByDirection(direction);
    assertEquals(orientation, "EST");
  }
  
}

