package carbonit.carbonit_project.mapper;

import carbonit.carbonit_project.business.model.bo.*;
import carbonit.carbonit_project.utils.ListesUtilitaires;

import java.util.ArrayList;
import java.util.Scanner;

public class FichierEntreeMapper {

    public static void mapFileToListes(Scanner scanner) {

        ArrayList<MontagneBO> listeMontagnes = new ArrayList<>();
        ArrayList<AventurierBO> listeAventuriers = new ArrayList<>();
        ArrayList<TresorsBO>  listeTresors = new ArrayList<>();
        ArrayList<CarteBO> listeCartes = new ArrayList<>();

        int valeurX;
        int valeurY;

        System.out.println("Contenu Fichier d'entrée");

        //génération des listes
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);

            String type = line.substring(0, 1);
            String[] parts = line.split("-");

            if (type.equals("C")) {
                valeurX = Integer.parseInt(parts[1].trim());
                valeurY = Integer.parseInt(parts[2].trim());
                listeCartes.add(new CarteBO(valeurX, valeurY));

            } else if (type.equals("M")) {
                valeurX = Integer.parseInt(parts[1].trim());
                valeurY = Integer.parseInt(parts[2].trim());
                listeMontagnes.add(new MontagneBO(valeurX, valeurY));

            } else if (type.equals("T")) {
                valeurX = Integer.parseInt(parts[1].trim());
                valeurY = Integer.parseInt(parts[2].trim());
                int nbTresor = Integer.parseInt(parts[3].trim());
                listeTresors.add(new TresorsBO(valeurX, valeurY, nbTresor));

            } else if (type.equals("A")) {
                String nom = parts[1].trim();
                valeurX = Integer.parseInt(parts[2].trim());
                valeurY = Integer.parseInt(parts[3].trim());
                String orientation = parts[4].trim();
                String pattern = parts[5].trim();
                listeAventuriers.add(new AventurierBO(nom, valeurX, valeurY, orientation, pattern));
            }
        }

        scanner.close();

        ListesUtilitaires.getInstance(listeMontagnes,
                            listeAventuriers,
                            listeTresors,
                            listeCartes)
                        .initListes(ListesUtilitaires.getListeMontagnes(),
                            ListesUtilitaires.getListeAventuriers(),
                            ListesUtilitaires.getListeTresors(),
                            ListesUtilitaires.getListeCartes());

        System.out.println();
        System.out.println();

    }

}
