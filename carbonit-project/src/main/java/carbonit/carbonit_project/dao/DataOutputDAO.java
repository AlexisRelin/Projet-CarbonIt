package carbonit.carbonit_project.dao;

import carbonit.carbonit_project.constantes.Constantes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** Classe d'écriture d'une liste sur un fichier de sortie */
public class DataOutputDAO {

    /**
     * Écrit le contenu d'une liste dans un fichier de sortie
     * @param listeAEcrire Liste à retranscrire dans le fichier de sortie
     * */
    public static void setOutputData(ArrayList<String> listeAEcrire){

        try {
            FileWriter writer = new FileWriter(Constantes.PATH_FICHIER_SORTIE);
            BufferedWriter bw = new BufferedWriter(writer);

            // Itération sur la liste avec des retours à la ligne
            for (String element : listeAEcrire) {
                bw.write(element);
                bw.newLine();
            }

            bw.close();
            System.out.println("Les lignes ont été écrites dans le fichier avec succès.");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
