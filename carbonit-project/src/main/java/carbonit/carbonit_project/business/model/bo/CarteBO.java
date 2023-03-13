package carbonit.carbonit_project.business.model.bo;

/**
 * BO de la carte
 */
public class CarteBO {

    /** Largeur de la carte */
    private int largeurX;
    /** Hauteur de la carte */
    private int hauteurY;

    /** Constructeur de la classe */
    public CarteBO(int largeurX, int hauteurY) {
        this.largeurX = largeurX;
        this.hauteurY = hauteurY;
    }

    /** Getter de largeurX */
    public int getLargeurX() {
        return largeurX;
    }

    /** Getter de la hauteur */
    public int getHauteurY() {
        return hauteurY;
    }

    @Override
    public String toString() {
        return "CarteBO{" +
                "largeurX=" + largeurX +
                ", hauteurY=" + hauteurY +
                '}';
    }
}
