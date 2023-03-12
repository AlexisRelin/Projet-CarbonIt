package carbonit.carbonit_project.utils;

import carbonit.carbonit_project.business.model.bo.AventurierBO;
import carbonit.carbonit_project.business.model.bo.CarteBO;
import carbonit.carbonit_project.business.model.bo.MontagneBO;
import carbonit.carbonit_project.business.model.bo.TresorsBO;

import java.util.ArrayList;

public class ListesUtilitaires  {
    private static ListesUtilitaires  instance;
    private static ArrayList<MontagneBO> listeMontagnes;
    private static ArrayList<AventurierBO> listeAventuriers;
    private static ArrayList<TresorsBO> listeTresors;
    private static ArrayList<CarteBO> listeCartes;

    private ListesUtilitaires (ArrayList<MontagneBO> listeMontagnes, ArrayList<AventurierBO> listeAventuriers,
                      ArrayList<TresorsBO> listeTresors, ArrayList<CarteBO> listeCartes) {
        this.listeMontagnes = listeMontagnes;
        this.listeAventuriers = listeAventuriers;
        this.listeTresors = listeTresors;
        this.listeCartes = listeCartes;
    }

    public static ListesUtilitaires getInstance(ArrayList<MontagneBO> listeMontagnes, ArrayList<AventurierBO> listeAventuriers,
                                                ArrayList<TresorsBO> listeTresors, ArrayList<CarteBO> listeCartes) {
        if (instance == null) {
            instance = new ListesUtilitaires(listeMontagnes, listeAventuriers, listeTresors, listeCartes);
        }
        return instance;
    }

    public static ArrayList<MontagneBO> getListeMontagnes() {
        return listeMontagnes;
    }

    public static ArrayList<AventurierBO> getListeAventuriers() {
        return listeAventuriers;
    }

    public static ArrayList<TresorsBO> getListeTresors() {
        return listeTresors;
    }

    public static ArrayList<CarteBO> getListeCartes() {
        return listeCartes;
    }

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
     * @return nombre de tours restant
     * */
    public static int getNombrePatternListeAventurierMax(ArrayList<AventurierBO> listeAventuriers) {
        int patternMax = 0;
        for (int i = 0; i < listeAventuriers.size(); i++) {
            int actualPattern = listeAventuriers.get(i).getPatternRestant().length();
            patternMax = actualPattern > patternMax ? actualPattern : patternMax;
        }
        return patternMax;
    }

    public static Boolean montagneExisteHere(int positionX, int positionY){
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

    public static Boolean aventurierExisteHere(int positionX, int positionY, String nom){
        Boolean aventurierExist = false;

        for (int i = 0; i < ListesUtilitaires.getListeAventuriers().size() ; i++) {

            if(nom.equals(ListesUtilitaires.getListeAventuriers().get(i).getNom())){
                continue;
            }

            aventurierExist = (ListesUtilitaires.getListeAventuriers().get(i).getPositionX() == positionX)
                    && (ListesUtilitaires.getListeAventuriers().get(i).getPositionY() == positionY);
            if (aventurierExist){
                break;
            }
        }
        return aventurierExist;
    }

    /**
     * Vérifie si la position entrée en paramètre est hors du plateau
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
