package carbonit.carbonit_project;

import carbonit.carbonit_project.business.model.bo.AventurierBO;
import carbonit.carbonit_project.dao.DataInputDAO;
import carbonit.carbonit_project.dao.DataOutputDAO;
import carbonit.carbonit_project.mapper.FichierEntreeMapper;
import carbonit.carbonit_project.mapper.FichierSortieMapper;
import carbonit.carbonit_project.utils.ListesUtilitaires;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principale de l'application
 */
public class App {

    public static void main(String[] args) {

        // Récupère les données du fichier d'entrée
        Scanner scanner = DataInputDAO.getInputData(args);

        // Mappe les données d'entrée en listes
        if (scanner != null) {
            FichierEntreeMapper.mapFileToListes(scanner);
        }

        ListesUtilitaires listesUtilitaires = ListesUtilitaires.getInstance();

        // Calcul nombre de tour de plateau
        int nombreTour = listesUtilitaires.getNombrePatternListeAventurierMax(listesUtilitaires.getListeAventuriers());

        // Pour chaque tour de plateau
        for(int i = 0; i < nombreTour; i++) {

            // Déplacer Aventurier 1 par 1 en commençant par le premier (prioritaire)
            for (int j =0 ; j < listesUtilitaires.getListeAventuriers().size() ; j++){

                AventurierBO aventurier = listesUtilitaires.getListeAventuriers().get(j);
                String prochaineDirection = aventurier.getNextDeplacement();
                String newOrientation = aventurier.getOrientationByDirection(prochaineDirection);

                int oldPositionX = aventurier.getPositionX();
                int oldPositionY = aventurier.getPositionY();

                // Calcul des nouvelles positions
                int[] nouvellePosition = aventurier.getNewCasePosition(newOrientation,
                        oldPositionX, oldPositionY, prochaineDirection, aventurier.getNom());
                int newPositionX = nouvellePosition[0];
                int newPositionY = nouvellePosition[1];

                // Vérifie si l'Aventurier est immobile sur ce tour pour ne pas qu'il ne prenne de nouveau un trésor
                Boolean aventurierImmobile =
                        aventurier.controleImmobilite(oldPositionX, oldPositionY, newPositionX, newPositionY);

                // Récupère le trésor pendant le déplacement s'il existe
                if(!aventurierImmobile && listesUtilitaires.prendTresorSiExisteIci(newPositionX, newPositionY)){
                    aventurier.ajouterTresorSac();
                }

                // Met à jour l'aventurier dans sa liste
                aventurier.setOrientation(newOrientation);
                aventurier.setPositionX(newPositionX);
                aventurier.setPositionY(newPositionY);
                aventurier.deplacementTermine();
                listesUtilitaires.getListeAventuriers().set(j, aventurier);
            }
        }

        // Map les listes métier en une liste destinée à écrire dans le fichier de sortie
        ArrayList<String> listeAEcrireFichier = FichierSortieMapper.mapListesMetierToListeData();
        // Écrit le fichier de sortie
        DataOutputDAO.setOutputData(listeAEcrireFichier);
    }


}
