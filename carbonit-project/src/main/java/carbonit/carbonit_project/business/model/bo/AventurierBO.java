package carbonit.carbonit_project.business.model.bo;

import carbonit.carbonit_project.constantes.Constantes;
import carbonit.carbonit_project.utils.ListesUtilitaires;

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

        if(direction.equals("A")){
            String newOrientation = "";
            switch(this.orientation){
                case "N" :
                    newOrientation = Constantes.NORD;
                    break;
                case "S" :
                    newOrientation = Constantes.SUD;
                    break;
                case "E" :
                    newOrientation = Constantes.EST;
                    break;
                case "O" :
                    newOrientation = Constantes.OUEST;
                    break;
                default:
                    newOrientation = this.orientation;
                    break;
            }
            return newOrientation;
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
     * Donne la position de l'aventurier après avoir avancé d'une case
     * S'il y a une montagne la position de l'aventurier ne bouge pas
     * */
    public static int[] getNewCasePosition(String orientation, int positionX, int positionY,
                                           String direction, String nom){

        int newPositionX = positionX;
        int newPositionY = positionY;

        if(direction.equals("A")) {

            newPositionY = orientation.equals(Constantes.NORD) ? positionY - 1 :
                    orientation.equals(Constantes.SUD) ? positionY + 1 : newPositionY;

            newPositionX = orientation.equals(Constantes.OUEST) ? positionX - 1 :
                    orientation.equals(Constantes.EST) ? positionY + 1 : newPositionX;
        }

        // Vérifie si c'est le bord du plateau
        if (ListesUtilitaires.sortieDePlateau(newPositionX, newPositionY)){
            System.out.println("Attention bord du plateau !");
            return new int[]{positionX, positionY};
        }

        // Vérifie si une montagne existe au nouvel emplacement
        if (ListesUtilitaires.montagneExisteHere(newPositionX, newPositionY)){
            System.out.println("Attention il y a une montagne !");
            return new int[]{positionX, positionY};
        }

        // Vérifie si un Aventurier existe au nouvel emplacement
        if (ListesUtilitaires.aventurierExisteHere(newPositionX, newPositionY, nom)){
            System.out.println("Attention il y a déjà un Aventurier !");
            return new int[]{positionX, positionY};
        }

        System.out.println("Aucune montagne en vue");
        return new int[]{newPositionX, newPositionY};
    }

    public String getPatternRestant() {
        return this.patternRestant;
    }

    /**
     * Donne le prochain déplacement
     */
    public String getNextDeplacement() {
        String deplacement = this.patternRestant.substring(0, 1);

        switch(deplacement){
            case "A" :
                deplacement = "A";
                break;
            case "D" :
                deplacement = Constantes.DROITE;
                break;
            case "G" :
                deplacement = Constantes.GAUCHE;
                break;
        }
        return deplacement;
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

    @Override
    public void setPositionX(int positionX) {
        super.setPositionX(positionX);
    }

    @Override
    public void setPositionY(int positionY) {
        super.setPositionY(positionY);
    }

    @Override
    public String toString() {
        return "Aventurier " + nom + " => \n" +
                "Position : (" + getPositionX() + ", " + getPositionY() + ")\n" +
                "Orientation : " + orientation + "\n" +
                "Nombre de trésors dans le sac : " + sacTresor + "\n" +
                "PatternRestant : " + patternRestant;
    }
}
