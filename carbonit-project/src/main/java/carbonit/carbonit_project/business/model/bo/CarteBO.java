package carbonit.carbonit_project.business.model.bo;

public class CarteBO {

    private int largeurX;
    private int hauteurY;

    public CarteBO(int largeurX, int hauteurY) {
        this.largeurX = largeurX;
        this.hauteurY = hauteurY;
    }

    public int getLargeurX() {
        return largeurX;
    }

    public void setLargeurX(int largeurX) {
        this.largeurX = largeurX;
    }

    public int getHauteurY() {
        return hauteurY;
    }

    public void setHauteurY(int hauteurY) {
        this.hauteurY = hauteurY;
    }
}
