package carbonit.carbonit_project.business.model.bo;

/** BO d'une montagne */
public class MontagneBO extends ElementBO {

    /** Constructeur de la classe montagne */
    public MontagneBO(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public String toString() {
        return "MontagneBO{positionX=" + getPositionX() + ", positionY=" + getPositionY() + "}";
    }
}

