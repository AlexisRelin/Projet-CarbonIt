package carbonit.carbonit_project.mapper;

import carbonit.carbonit_project.business.model.bo.AventurierBO;
import carbonit.carbonit_project.business.model.bo.CarteBO;
import carbonit.carbonit_project.business.model.bo.MontagneBO;
import carbonit.carbonit_project.business.model.bo.TresorsBO;
import carbonit.carbonit_project.constantes.Constantes;
import carbonit.carbonit_project.utils.ListesUtilitaires;

import java.util.ArrayList;
import java.util.Scanner;

public class FichierSortieMapper {


    public static ArrayList<String> mapListesMetierToListeData() {

        ArrayList<String> listeAEcrire = new ArrayList<String>();

        // Carte
        CarteBO carte = ListesUtilitaires.getListeCartes().get(0);

        StringBuilder sb = new StringBuilder();
        sb.append(Constantes.SIGLE_CARTE);
        sb.append(Constantes.SEPARATEUR_FICHIERS);
        sb.append(String.valueOf(carte.getLargeurX()));
        sb.append(Constantes.SEPARATEUR_FICHIERS);
        sb.append(String.valueOf(carte.getHauteurY()));
        listeAEcrire.add(sb.toString());
        sb.setLength(0);

        // Montagne
        for (MontagneBO montagne : ListesUtilitaires.getListeMontagnes()){
            sb.append(Constantes.SIGLE_MONTAGNE);
            sb.append(Constantes.SEPARATEUR_FICHIERS);
            sb.append(montagne.getPositionX());
            sb.append(Constantes.SEPARATEUR_FICHIERS);
            sb.append(montagne.getPositionY());

            listeAEcrire.add(sb.toString());
            sb.setLength(0);
        }

        // Tresors
        for (TresorsBO tresors : ListesUtilitaires.getListeTresors()){
            sb.append(Constantes.SIGLE_TRESOR);
            sb.append(Constantes.SEPARATEUR_FICHIERS);
            sb.append(tresors.getPositionX());
            sb.append(Constantes.SEPARATEUR_FICHIERS);
            sb.append(tresors.getPositionY());
            sb.append(Constantes.SEPARATEUR_FICHIERS);
            sb.append(tresors.getTresor());

            listeAEcrire.add(sb.toString());
            sb.setLength(0);
        }

        // Aventuriers
        for (AventurierBO aventurier : ListesUtilitaires.getListeAventuriers()){
            sb.append(Constantes.SIGLE_AVENTURIER);
            sb.append(Constantes.SEPARATEUR_FICHIERS);
            sb.append(aventurier.getNom());
            sb.append(Constantes.SEPARATEUR_FICHIERS);
            sb.append(aventurier.getPositionX());
            sb.append(Constantes.SEPARATEUR_FICHIERS);
            sb.append(aventurier.getPositionY());
            sb.append(Constantes.SEPARATEUR_FICHIERS);
            sb.append(aventurier.getOrientation());
            sb.append(Constantes.SEPARATEUR_FICHIERS);
            sb.append(aventurier.getSacTresor());

            listeAEcrire.add(sb.toString());
            sb.setLength(0);
        }

        return listeAEcrire;
    }
}
