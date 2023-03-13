package carbonit.carbonit_project.business.model.bo;

/**
 * Classe abstraite d'un élément de la carte
 * */
public abstract class ElementBO {

    /** Position abscisse */
    private int positionX;
    /** Position ordonnée */
    private int positionY;

    /** Constructeur de la classe */
    public ElementBO(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /** Getter de positionX */
    public int getPositionX() {
        return positionX;
    }

    /** Getter de positionY */
    public int getPositionY() {
        return positionY;
    }

    /** Setter de positionX */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /** Setter de positionY */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
