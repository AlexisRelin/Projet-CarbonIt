package carbonit.carbonit_project.mapper;

import carbonit.carbonit_project.business.model.bo.*;
import carbonit.carbonit_project.constantes.Constantes;
import carbonit.carbonit_project.utils.ListesUtilitaires;

import java.util.ArrayList;
import java.util.Scanner;

/** Mapper permettant de convertir au bon format d'objet les données en entrée pour le métier */
public class FichierEntreeMapper {

    /**
     * Map les données du scanner en listes métier
     * @param scanner scanner contenant les données d'entrée
     * */
    public static ListesUtilitaires mapFileToListes(Scanner scanner) {

        ArrayList<MontagneBO> listeMontagnes = new ArrayList<>();
        ArrayList<AventurierBO> listeAventuriers = new ArrayList<>();
        ArrayList<TresorsBO>  listeTresors = new ArrayList<>();
        ArrayList<CarteBO> listeCartes = new ArrayList<>();

        int valeurX;
        int valeurY;

        //génération des listes
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String type = line.substring(0, 1);
            String[] parts = line.split(Constantes.SEPARATEUR_FICHIERS);

            if (type.equals(Constantes.SIGLE_CARTE)) {
                valeurX = Integer.parseInt(parts[1]);
                valeurY = Integer.parseInt(parts[2]);
                listeCartes.add(new CarteBO(valeurX, valeurY));

            } else if (type.equals(Constantes.SIGLE_MONTAGNE)) {
                valeurX = Integer.parseInt(parts[1]);
                valeurY = Integer.parseInt(parts[2]);
                listeMontagnes.add(new MontagneBO(valeurX, valeurY));

            } else if (type.equals(Constantes.SIGLE_TRESOR)) {
                valeurX = Integer.parseInt(parts[1]);
                valeurY = Integer.parseInt(parts[2]);
                int nbTresor = Integer.parseInt(parts[3]);
                listeTresors.add(new TresorsBO(valeurX, valeurY, nbTresor));

            } else if (type.equals(Constantes.SIGLE_AVENTURIER)) {
                String nom = parts[1].trim();
                valeurX = Integer.parseInt(parts[2]);
                valeurY = Integer.parseInt(parts[3]);
                String orientation = parts[4];
                String pattern = parts[5];
                listeAventuriers.add(new AventurierBO(nom, valeurX, valeurY, orientation, pattern));
            }
        }

        scanner.close();

        // Initialisation des listes
        ListesUtilitaires.initListes(listeMontagnes, listeAventuriers, listeTresors, listeCartes);

        // Création de l'instance du singleton
        return ListesUtilitaires.getInstance(listeMontagnes,
                listeAventuriers, listeTresors, listeCartes);
    }
}
