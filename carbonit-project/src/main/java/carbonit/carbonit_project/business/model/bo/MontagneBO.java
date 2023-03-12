package carbonit.carbonit_project.business.model.bo;

public class MontagneBO extends ElementBO {

    public MontagneBO(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public String toString() {
        return "MontagneBO{positionX=" + getPositionX() + ", positionY=" + getPositionY() + "}";
    }
}

