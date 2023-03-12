package carbonit.carbonit_project.business.model.bo;

/** BO d'un trésor */
public class TresorsBO extends ElementBO {

    /** Quantité de trésor */
    private int tresor;

    /** Constructeur de la classe TresorsBO */
    public TresorsBO(int positionX, int positionY, int tresor) {
        super(positionX, positionY);
        this.tresor = tresor;
    }

    /** Getter du nombre de trésors */
    public int getTresor() {
        return tresor;
    }

    /** Setter du nombre de trésors */
    public void setTresor(int tresor) {
        this.tresor = tresor;
    }

    @Override
    public String toString() {
        return "TresorsBO{positionX=" + getPositionX() + ", positionY=" + getPositionY() +
                ", tresor=" + getTresor() + "}";
    }
}
