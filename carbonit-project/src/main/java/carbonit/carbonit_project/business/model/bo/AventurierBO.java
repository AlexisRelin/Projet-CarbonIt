package carbonit.carbonit_project.business.model.bo;

import carbonit.carbonit_project.constantes.Constantes;
import carbonit.carbonit_project.utils.ListesUtilitaires;

import java.util.HashMap;
import java.util.Map;

/**
 * BO de l'aventurier
 * */
public class AventurierBO extends ElementBO {

    /** Nombre de trésors récupérés  */
    private int sacTresor;
    /** Orientation de l'aventurier  */
    private String orientation;
    /** Déplacement restant de la forme "AADADAGGA" */
    private String patternRestant;
    /** Nom de l'aventurier */
    private final String nom;

    /** Constructeur de la classe */
    public AventurierBO(String nom, int positionX, int positionY, String orientation, String patternRestant) {
        super(positionX, positionY);
        this.nom = nom;
        this.sacTresor = 0;
        this.orientation = orientation;
        this.patternRestant = patternRestant;
    }

    /** Getter de sacTresor */
    public int getSacTresor() {
        return this.sacTresor;
    }

    /** Getter de orientation */
    public String getOrientation() {
        return this.orientation;
    }

    /** Setter de orientation */
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    /** Getter du nom */
    public String getNom() {
        return nom;
    }

    /**
     * Donne la future orientation de l'aventurier par rapport à une direction et à l'orientation actuelle. <br/>
     * (Exemple : direction DROITE avec orientation NORD donne une orientation EST)
     * @param direction La direction prise par l'aventurier
     * @return La nouvelle orientation
     */
    public String getOrientationByDirection(String direction) {

        // Avancer ne change pas l'orientation de l'aventurier
        if(direction.equals(Constantes.AVANCE)){
            return this.orientation;
        }

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
        estMap.put(Constantes.DROITE, Constantes.SUD);
        estMap.put(Constantes.GAUCHE, Constantes.NORD);
        orientations.put(Constantes.EST, estMap);

        // Set des combinaisons qui vont à l'ouest
        Map<String, String> ouestMap = new HashMap<>();
        ouestMap.put(Constantes.DROITE, Constantes.NORD);
        ouestMap.put(Constantes.GAUCHE, Constantes.SUD);
        orientations.put(Constantes.OUEST, ouestMap);

        // Cherche la map correspondant à l'orientation puis y cherche la valeur de la direction correspondante.
        return orientations.get(this.orientation).get(direction);
    }

    /**
     * Donne la nouvelle position de l'aventurier après avoir avancé d'une case<br/>
     * Dans plusieurs cas l'aventurier ne bougera pas : <br/>
     * - Son déplacement le ferait sortir de la carte <br/>
     * - Une montagne est devant lui <br/>
     * - Un autre aventurier est devant lui
     * @param orientation L'orientation de l'aventurier
     * @param positionX Position actuelle de l'aventurier sur l'axe X
     * @param positionY Position actuelle de l'aventurier sur l'axe Y
     * @param direction Direction que prend l'aventurier
     * @param nom Nom de l'aventurier en déplacement
     * */
    public static int[] getNewCasePosition(String orientation, int positionX, int positionY,
                                           String direction, String nom){
        int newPositionX = positionX;
        int newPositionY = positionY;

        // Calcul de son nouvel emplacement s'il avance
        if(direction.equals(Constantes.AVANCE)) {
            newPositionY = orientation.equals(Constantes.NORD) ? positionY - 1 :
                    orientation.equals(Constantes.SUD) ? positionY + 1 : newPositionY;
            newPositionX = orientation.equals(Constantes.OUEST) ? positionX - 1 :
                    orientation.equals(Constantes.EST) ? positionY + 1 : newPositionX;
        }

        // Vérifie si c'est le bord du plateau
        if (ListesUtilitaires.sortieDePlateau(newPositionX, newPositionY)){
            return new int[]{positionX, positionY};
        }

        // Vérifie si une montagne existe au nouvel emplacement
        if (ListesUtilitaires.montagneExisteIci(newPositionX, newPositionY)){
            return new int[]{positionX, positionY};
        }

        // Vérifie si un Aventurier existe au nouvel emplacement
        if (ListesUtilitaires.aventurierExisteIci(newPositionX, newPositionY, nom)){
            return new int[]{positionX, positionY};
        }

        return new int[]{newPositionX, newPositionY};
    }

    /** Donne le pattern de déplacement restant pour l'aventurier */
    public String getPatternRestant() {
        return this.patternRestant;
    }

    /** Donne le prochain déplacement de l'aventurier */
    public String getNextDeplacement() {
        return this.patternRestant.substring(0, 1);
    }

    /** Supprime le dernier déplacement du pattern de déplacement */
    public void deplacementTermine() {
        this.patternRestant = patternRestant.substring(1);
    }

    /** Incrémente de 1 le nombre de trésors dans le sac de l'aventurier */
    public void ajouterTresorSac() {
        this.sacTresor++;
    }

    /**
     * Contrôle si sur ce tour l'aventurier ne changera pas de case
     * @param oldPositionX Position actuelle de l'aventurier sur l'axe X
     * @param oldPositionY Position actuelle de l'aventurier sur l'axe Y
     * @param newPositionX Prochaine position de l'aventurier sur l'axe X
     * @param newPositionY Prochaine position de l'aventurier sur l'axe Y
     * @return True si l'aventurier reste sur la même case
     * */
    public static Boolean controleImmobilite(int oldPositionX, int oldPositionY, int newPositionX, int newPositionY){
        return (oldPositionX == newPositionX && oldPositionY == newPositionY);
    }

    /** Surcharge du setter de position X */
    @Override
    public void setPositionX(int positionX) {
        super.setPositionX(positionX);
    }

    /** Surcharge du setter de position Y */
    @Override
    public void setPositionY(int positionY) {
        super.setPositionY(positionY);
    }

    /** Surcharge du toString */
    @Override
    public String toString() {
        return "Aventurier " + nom + " => \n" +
                "Position : (" + getPositionX() + ", " + getPositionY() + ")\n" +
                "Orientation : " + orientation + "\n" +
                "Nombre de trésors dans le sac : " + sacTresor + "\n" +
                "PatternRestant : " + patternRestant;
    }
}
