package carbonit.carbonit_project.dao;

import carbonit.carbonit_project.constantes.Constantes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Classe de récupération des data en provenance d'un fichier d'entrée */
public class DataInputDAO {

    /**
     * Renvoi le scanner contenant les données d'entrée
     * @param args argument contenant le nom du fichier d'entrée
     * @return Scanner des données d'entrée
     * */
    public static Scanner getInputData(String[] args){
        // Contrôle des paramètres d'entrée
        if (controlerParametresEntree(args).equals(false)) {
            return null;
        }
        // Lecture du fichier
        return lireFichier(args[0]);
    }

    /**
     * Lecture du fichier d'entrée
     * @param fileName Nom du fichier avec son extension
     * @return Scanner du contenu du fichier
     * */
    private static Scanner lireFichier(String fileName){
        Scanner scanner = null;
        try {
            File inputFile = new File(Constantes.PATH_FICHIER_ENTREE + fileName);
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier " + fileName + "n'a pas été trouvé : " + e.getMessage());
        }
        return scanner;
    }

    /**
     * Contrôle la présence des paramètres d'entrées obligatoires
     * @param arguments args au run de l'application
     * @return True si le nombre de paramètres est conforme
     */
    private static Boolean controlerParametresEntree(String[] arguments){
        if (arguments.length != 1) {
            System.out.println("Vous devez uniquement renseigner le nom du fichier en paramètre d'entrée.");
            return false;
        }
        return true;
    }

}
