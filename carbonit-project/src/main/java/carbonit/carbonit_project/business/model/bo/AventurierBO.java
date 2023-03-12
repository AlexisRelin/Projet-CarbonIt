package carbonit.carbonit_project.business.model.bo;

import carbonit.carbonit_project.constantes.Constantes;

import java.util.HashMap;
import java.util.Map;

public class AventurierBO extends ElementBO {

    /**
     * Nombre de trésors récupérés
     */
    private int sacTresor;
    /**
     * Orientation de l'aventurier
     */
    private String orientation;
    /**
     * Déplacement restant de la forme "AADADAGGA"
     */
    private String patternRestant;
    /**
     * Nom de l'aventurier
     */
    private String nom;

    public AventurierBO(String nom, int positionX, int positionY, String orientation, String patternRestant) {
        super(positionX, positionY);
        this.nom = nom;
        this.sacTresor = 0;
        this.orientation = orientation;
        this.patternRestant = patternRestant;
    }

    public int getSacTresor() {
        return this.sacTresor;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getNom() {
        return nom;
    }

    /**
     * Donne la future orientation par rapport à un déplacement
     */
    public String getOrientationByDirection(String direction) {

        // Création d'une map de la forme Map<String, Map>
        Map<String, Map<String, String>> orientations = new HashMap<>();

        // Set des combinaisons qui vont au nord
        Map<String, String> nordMap = new HashMap<>();
        nordMap.put(Constantes.DROITE, Constantes.EST);
        nordMap.put(Constantes.GAUCHE, Constantes.OUEST);
        orientations.put(Constantes.NORD, nordMap);

        // Set des combinaisons qui vont au sud
        Map<String, String> sudMap = new HashMap<>();
        sudMap.put(Constantes.DROITE, Constantes.OUEST);
        sudMap.put(Constantes.GAUCHE, Constantes.EST);
        orientations.put(Constantes.SUD, sudMap);

        // Set des combinaisons qui vont à l'est
        Map<String, String> estMap = new HashMap<>();
        estMap.put(Constantes.DROITE, Constantes.NORD);
        estMap.put(Constantes.GAUCHE, Constantes.SUD);
        orientations.put(Constantes.EST, estMap);

        // Set des combinaisons qui vont à l'ouest
        Map<String, String> ouestMap = new HashMap<>();
        ouestMap.put(Constantes.DROITE, Constantes.SUD);
        ouestMap.put(Constantes.GAUCHE, Constantes.NORD);
        orientations.put(Constantes.OUEST, ouestMap);

        // Cherche la map correspondant à l'orientation puis y cherche la valeur de la direction correspondante.
        return orientations.get(orientation).get(direction);
    }

    public String getPatternRestant() {
        return this.patternRestant;
    }

    /**
     * Donne le prochain déplacement
     */
    public String getNextDeplacement() {
        return this.patternRestant.substring(0, 1);
    }

    /**
     * Informe que le déplacement en cours est terminé et le retire de son pattern de déplacement à réaliser
     */
    public void deplacementTermine() {
        this.patternRestant = patternRestant.substring(1, patternRestant.length());
    }

    /**
     * Incrémente de 1 le nombre de trésors dans le sac de l'aventurier
     */
    public void ajouterTresorSac() {
        this.sacTresor++;
    }

}
