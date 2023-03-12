package carbonit.carbonit_project.utils;

import carbonit.carbonit_project.business.model.bo.AventurierBO;
import carbonit.carbonit_project.business.model.bo.CarteBO;
import carbonit.carbonit_project.business.model.bo.MontagneBO;
import carbonit.carbonit_project.business.model.bo.TresorsBO;

import java.util.ArrayList;

/** Classe des listes métier */
public class ListesUtilitaires  {

    /** instance de la classe (singleton) */
    private static ListesUtilitaires  instance;
    /** Liste des montagnes */
    private static ArrayList<MontagneBO> listeMontagnes;
    /** Liste des aventuriers */
    private static ArrayList<AventurierBO> listeAventuriers;
    /** Liste des trésors*/
    private static ArrayList<TresorsBO> listeTresors;
    /** Liste contenant la carte */
    private static ArrayList<CarteBO> listeCartes;

    /** Constructeur de la classe */
    private ListesUtilitaires (ArrayList<MontagneBO> listeMontagnes, ArrayList<AventurierBO> listeAventuriers,
                      ArrayList<TresorsBO> listeTresors, ArrayList<CarteBO> listeCartes) {
        this.listeMontagnes = listeMontagnes;
        this.listeAventuriers = listeAventuriers;
        this.listeTresors = listeTresors;
        this.listeCartes = listeCartes;
    }

    /** Récupération de l'instance du singleton */
    public static ListesUtilitaires getInstance(ArrayList<MontagneBO> listeMontagnes, ArrayList<AventurierBO> listeAventuriers,
                                                ArrayList<TresorsBO> listeTresors, ArrayList<CarteBO> listeCartes) {
        if (instance == null) {
            instance = new ListesUtilitaires(listeMontagnes, listeAventuriers, listeTresors, listeCartes);
        }
        return instance;
    }

    /** Getter de listeMontagnes */
    public static ArrayList<MontagneBO> getListeMontagnes() {
        return listeMontagnes;
    }

    /** Getter de listeAventuriers */
    public static ArrayList<AventurierBO> getListeAventuriers() {
        return listeAventuriers;
    }

    /** Getter de listeTresors */
    public static ArrayList<TresorsBO> getListeTresors() {
        return listeTresors;
    }

    /** Getter de listeCartes */
    public static ArrayList<CarteBO> getListeCartes() {
        return listeCartes;
    }

    /**
     * Initialise les listes par celles entrées en paramètre
     * @param maListeCartes listeCartes à initialiser
     * @param maListeAventuriers listeAventuriers à initialiser
     * @param maListeTresors listeTresors à initialiser
     * @param maListeMontagnes listeMontagnes à initialiser
     * */
    public static void initListes(ArrayList<MontagneBO> maListeMontagnes, ArrayList<AventurierBO> maListeAventuriers,
                           ArrayList<TresorsBO> maListeTresors, ArrayList<CarteBO> maListeCartes) {
        listeMontagnes = maListeMontagnes;
        listeAventuriers = maListeAventuriers;
        listeTresors = maListeTresors;
        listeCartes = maListeCartes;
    }

    /**
     * Récupère le nombre de tours maximum pour effectuer tous les déplacements des aventuriers
     * @param listeAventuriers Liste des aventuriers
     * @return nombre de tours maximum pour completer le pattern de déplacement
     * */
    public static int getNombrePatternListeAventurierMax(ArrayList<AventurierBO> listeAventuriers) {
        int patternMax = 0;
        for (int i = 0; i < listeAventuriers.size(); i++) {
            int actualPattern = listeAventuriers.get(i).getPatternRestant().length();
            patternMax = actualPattern > patternMax ? actualPattern : patternMax;
        }
        return patternMax;
    }

    /**
     * Contrôle l'existence d'une montagne à une position donnée
     * @param positionX position X où contrôler la présence de montagne
     * @param positionY position Y où contrôler la présence de montagne
     * @return True si une montagne existe sur cette position
     * */
    public static Boolean montagneExisteIci(int positionX, int positionY){
        Boolean montagneExist = false;

        for (int i = 0; i < ListesUtilitaires.getListeMontagnes().size() ; i++) {
        montagneExist = (ListesUtilitaires.getListeMontagnes().get(i).getPositionX() == positionX)
                && (ListesUtilitaires.getListeMontagnes().get(i).getPositionY() == positionY);
            if (montagneExist){
                break;
            }
        }
        return montagneExist;
    }

    /**
     * Contrôle l'existence d'un aventurier à une position donnée.
     * @param positionX position X où contrôler la présence d'un aventurier
     * @param positionY position Y où contrôler la présence d'un aventurier
     * @param nom de l'aventurier qui contrôle la présence d'un autre aventurier
     * @return True si une montagne existe sur cette position
     * */
    public static Boolean aventurierExisteIci(int positionX, int positionY, String nom){
        Boolean aventurierExist = false;

        for (int i = 0; i < ListesUtilitaires.getListeAventuriers().size() ; i++) {

            // L'aventurier ne compare pas sa position avec lui-même
            if(nom.equals(ListesUtilitaires.getListeAventuriers().get(i).getNom())){
                continue;
            }
            // Comparaison des positions
            aventurierExist = (ListesUtilitaires.getListeAventuriers().get(i).getPositionX() == positionX)
                    && (ListesUtilitaires.getListeAventuriers().get(i).getPositionY() == positionY);
            if (aventurierExist){
                break;
            }
        }
        return aventurierExist;
    }

    /**
     * Vérifie la présence d'un trésor et décrémente sa quantité s'il existe
     * @param positionX Position sur X où contrôler la présence du trésor
     * @param positionY Position sur Y où contrôler la présence du trésor
     * @return True si le trésor a été repéré et qu'il n'est pas vide
     * */
    public static Boolean prendTresorSiExisteIci(int positionX, int positionY){
        Boolean tresorExist = false;

        for (int i = 0; i < ListesUtilitaires.getListeTresors().size() ; i++) {
            int NbTresor = ListesUtilitaires.getListeTresors().get(i).getTresor();

            tresorExist = (ListesUtilitaires.getListeTresors().get(i).getPositionX() == positionX)
                    && (ListesUtilitaires.getListeTresors().get(i).getPositionY() == positionY)
                    && NbTresor > 0;

            // vide le trésor d'une unité
            if (tresorExist){
                NbTresor = NbTresor -1;
                ListesUtilitaires.getListeTresors().get(i).setTresor(NbTresor);
                break;
            }
        }
        return tresorExist;
    }

    /**
     * Vérifie si la position entrée en paramètre est hors du plateau
     * @param positionX Position sur l'axe des X à contrôler
     * @param positionY Position sur l'axe des Y à contrôler
     * @return True si la position est en dehors du plateau
     * */
    public static Boolean sortieDePlateau(int positionX, int positionY){
        CarteBO plateau = ListesUtilitaires.getListeCartes().get(0);
        return positionX == plateau.getLargeurX() || positionY == plateau.getHauteurY()
                || positionX < 0 || positionY < 0;
    }

    @Override
    public String toString() {
        return "ListesUtilitaires{" +
                "listeMontagnes=" + listeMontagnes +
                ", listeAventuriers=" + listeAventuriers +
                ", listeTresors=" + listeTresors +
                ", listeCartes=" + listeCartes +
                '}';
    }

}
