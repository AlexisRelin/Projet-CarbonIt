package carbonit.carbonit_project.mapper;

import carbonit.carbonit_project.business.model.bo.AventurierBO;
import carbonit.carbonit_project.business.model.bo.CarteBO;
import carbonit.carbonit_project.business.model.bo.MontagneBO;
import carbonit.carbonit_project.business.model.bo.TresorsBO;
import carbonit.carbonit_project.constantes.Constantes;
import carbonit.carbonit_project.utils.ListesUtilitaires;

import java.util.ArrayList;

/** Mapper permettant de convertir au bon format d'objet les données métier en donnée à écrire en sortie */
public class FichierSortieMapper {

    /**
     * Map les listes métier en une liste à destination de l'écriture dans un fichier
     * @return liste de String contenant les lignes à écrire dans le fichier
     * */
    public static ArrayList<String> mapListesMetierToListeData() {

        ArrayList<String> listeAEcrire = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        // Mise au format d'une ligne Carte
        CarteBO carte = ListesUtilitaires.getListeCartes().get(0);
        sb.append(Constantes.SIGLE_CARTE);
        sb.append(Constantes.SEPARATEUR_FICHIERS);
        sb.append(String.valueOf(carte.getLargeurX()));
        sb.append(Constantes.SEPARATEUR_FICHIERS);
        sb.append(String.valueOf(carte.getHauteurY()));

        listeAEcrire.add(sb.toString());
        sb.setLength(0);

        // Mise au format d'une ligne Montagne
        for (MontagneBO montagne : ListesUtilitaires.getListeMontagnes()){
            sb.append(Constantes.SIGLE_MONTAGNE);
            sb.append(Constantes.SEPARATEUR_FICHIERS);
            sb.append(montagne.getPositionX());
            sb.append(Constantes.SEPARATEUR_FICHIERS);
            sb.append(montagne.getPositionY());

            listeAEcrire.add(sb.toString());
            sb.setLength(0);
        }

        // Mise au format d'une ligne Tresors
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

        // Mise au format d'une ligne Aventuriers
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
