package carbonit.carbonit_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;

import carbonit.carbonit_project.business.model.bo.*;
import carbonit.carbonit_project.dao.DataInputDAO;
import carbonit.carbonit_project.mapper.CarteMapper;
import carbonit.carbonit_project.mapper.FichierEntreeMapper;

import carbonit.carbonit_project.constantes.Constantes;
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

        // Création du plateau
        Object[][] plateau = CarteMapper.fromListToCarte();

        // Calcul nombre de tour
        int nombreTour = ListesUtilitaires.getNombrePatternListeAventurierMax(ListesUtilitaires.getListeAventuriers());
		System.out.println(nombreTour);
    }



}
