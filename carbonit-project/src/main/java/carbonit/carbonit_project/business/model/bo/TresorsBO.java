package carbonit.carbonit_project.business.model.bo;

public class TresorsBO extends ElementBO {

    /** Quantité de trésor*/
    private int tresor;

    public TresorsBO(int positionX, int positionY, int tresor) {
        super(positionX, positionY);
        this.tresor = tresor;
    }

    public int getTresor() {
        return tresor;
    }

    public void setTresor(int tresor) {
        this.tresor = tresor;
    }
}
