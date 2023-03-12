package carbonit.carbonit_project.dao;

import carbonit.carbonit_project.constantes.Constantes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataInputDAO {

    /** Récupère le scanner contenant les données d'entrée*/
    public static Scanner getInputData(String[] args){

        Scanner scanner;
        Boolean parametresOK = controlerParametresEntree(args);
        if (parametresOK.equals(false)) {
            return null;
        }

        String fileName = args[0];
        return lireFichier(fileName);
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

    /***
     * Contrôle la présence des paramètres d'entrées obligatoires
     */
    private static Boolean controlerParametresEntree(String[] arguments){
        if (arguments.length != 1) {
            System.out.println("Vous devez renseigner le nom du fichier en paramètre d'entrée.");
            return false;
        }
        return true;
    }

}
