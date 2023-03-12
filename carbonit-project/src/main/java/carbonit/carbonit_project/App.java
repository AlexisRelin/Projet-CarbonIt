package carbonit.carbonit_project;

import java.util.Scanner;

import carbonit.carbonit_project.business.model.bo.*;
import carbonit.carbonit_project.dao.DataInputDAO;
import carbonit.carbonit_project.mapper.CarteMapper;
import carbonit.carbonit_project.mapper.FichierEntreeMapper;

import carbonit.carbonit_project.utils.ListesUtilitaires;

/**
 * Classe principale de l'application
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Début de la methode Main");

        // Récupère les données du fichier d'entrée
        Scanner scanner = DataInputDAO.getInputData(args);

        // Mappe les données d'entrée en listes
        FichierEntreeMapper.mapFileToListes(scanner);
        System.out.println("Listes Montagne = " + ListesUtilitaires.getListeMontagnes().toString());
        System.out.println("Listes Aventurier = " + ListesUtilitaires.getListeAventuriers().toString());
        System.out.println();
        // Création du plateau
        Object[][] plateau = CarteMapper.fromListToCarte();

        // Calcul nombre de tour
        int nombreTour = ListesUtilitaires.getNombrePatternListeAventurierMax(ListesUtilitaires.getListeAventuriers());
        System.out.println("Nombre de Tour = " + nombreTour);

        // Pour chaque tour de plateau
        for(int i = 0; i < nombreTour; i++) {
            System.out.println("________________________ ");
            System.out.println("Tour en cours = " + i);
            System.out.println();


            // Déplacer Aventurier 1 par 1 en commençant par le premier (prioritaire)
            for (int j =0 ; j < ListesUtilitaires.getListeAventuriers().size() ; j++){

                AventurierBO aventurier = ListesUtilitaires.getListeAventuriers().get(j);
                //System.out.println("Avant");
                //System.out.println(aventurier.toString());
                //System.out.println();

                String prochaineDirection = aventurier.getNextDeplacement();
                //System.out.println("prochaineDirection = " + prochaineDirection);
                String newOrientation = aventurier.getOrientationByDirection(prochaineDirection);
                //System.out.println("newOrientation = " + newOrientation);

                int oldPositionX = aventurier.getPositionX();
                int oldPositionY = aventurier.getPositionY();
                //System.out.println("oldPositionX = " + oldPositionX);
                //System.out.println("oldPositionY = " + oldPositionY);

                int[] nouvellePosition = aventurier.getNewCasePosition(newOrientation,
                        oldPositionX, oldPositionY, prochaineDirection, aventurier.getNom());
                int newPositionX = nouvellePosition[0];
                int newPositionY = nouvellePosition[1];
                //System.out.println("newPositionX = " + newPositionX);
                //System.out.println("newPositionY = " + newPositionY);

                aventurier.setOrientation(newOrientation);
                aventurier.setPositionX(newPositionX);
                aventurier.setPositionY(newPositionY);
                aventurier.deplacementTermine();

                // Met à jour l'aventurier dans sa liste
                ListesUtilitaires.getListeAventuriers().set(j, aventurier);
                plateau[newPositionX][newPositionY] = aventurier;
                plateau[oldPositionX][oldPositionY] = "Plaine";
                System.out.println();
                System.out.println("Après");
                System.out.println(aventurier.toString());
                System.out.println();
                System.out.println();
            }



        }
        System.out.println("Listes Montagne = " + ListesUtilitaires.getListeMontagnes().toString());
        System.out.println("Listes Aventurier = " + ListesUtilitaires.getListeAventuriers().toString());
    }


}
