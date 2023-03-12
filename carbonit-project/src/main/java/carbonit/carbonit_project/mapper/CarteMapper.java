package carbonit.carbonit_project.mapper;

import carbonit.carbonit_project.business.model.bo.AventurierBO;
import carbonit.carbonit_project.business.model.bo.CarteBO;
import carbonit.carbonit_project.business.model.bo.MontagneBO;
import carbonit.carbonit_project.business.model.bo.TresorsBO;
import carbonit.carbonit_project.utils.ListesUtilitaires;

import java.util.ArrayList;

public class CarteMapper {

    private static Object[][] plateau;

    public static Object[][] fromListToCarte() {

        ListesUtilitaires instance = ListesUtilitaires.getInstance();
        ArrayList<MontagneBO> listeMontagnes = instance.getListeMontagnes();
        ArrayList<AventurierBO> listeAventuriers = instance.getListeAventuriers();
        ArrayList<TresorsBO> listeTresors = instance.getListeTresors();
        ArrayList<CarteBO> listeCartes = instance.getListeCartes();

        CarteBO carte = listeCartes.get(0);
        plateau = new String[carte.getLargeurX()][carte.getHauteurY()];

        ajouterPlaine(carte.getLargeurX(), carte.getHauteurY());
        ajouterMontagne(listeMontagnes);
        ajouterTresors(listeTresors);
        ajouterAventurier(listeAventuriers);

        return plateau;
    }

    private static void ajouterPlaine(int longueur, int largeur) {
        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                plateau[i][j] = "Plaine";
            }
        }
    }

    private static void ajouterMontagne(ArrayList<MontagneBO> listeMontagnes) {
        for (int i = 0; i < listeMontagnes.size(); i++) {
            MontagneBO montagne = listeMontagnes.get(i);
            plateau[montagne.getPositionX()][montagne.getPositionY()] = montagne;
        }
    }

    private static void ajouterTresors(ArrayList<TresorsBO> listeTresors) {
        for (int i = 0; i < listeTresors.size(); i++) {
            TresorsBO tresor = listeTresors.get(i);
            plateau[tresor.getPositionX()][tresor.getPositionY()] = tresor;
        }
    }

    private static void ajouterAventurier(ArrayList<AventurierBO> listeAventuriers) {
        for (int i = 0; i < listeAventuriers.size(); i++) {
            AventurierBO aventurier = listeAventuriers.get(i);
            plateau[aventurier.getPositionX()][aventurier.getPositionY()] = aventurier;
        }
    }
}
