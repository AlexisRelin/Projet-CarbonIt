package carbonit.carbonit_project.business.model.bo;

public abstract class ElementBO {

    /** Position abscisse */
    private int positionX;
    /** Position ordonnée */
    private int positionY;

    public ElementBO(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

}
