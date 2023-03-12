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

    public static ListesUtilitaires  getInstance() {
        if (instance == null) {
            throw new IllegalStateException("L'instance de ListesUtilitaires n'a pas été initialisée.");
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
}
