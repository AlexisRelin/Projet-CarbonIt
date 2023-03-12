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

	private static final Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
		logger.info("MyClass starting");
		System.out.println("Début de le classe Main");

		// Récupère les données du fichier d'entrée
		Scanner scanner = DataInputDAO.getInputData(args);

		// Mappe les données d'entrée en listes
		FichierEntreeMapper.mapFileToListes(scanner);

		// Création du plateau
		Object[][] plateau = CarteMapper.fromListToCarte();

		// Calcul nombre de tour


	}

	private int calclulNombreTour(){
		ListesUtilitaires instance = ListesUtilitaires.getInstance();
		ArrayList<AventurierBO> listeAventuriers = instance.getListeAventuriers();

		for (int i = 0; i < listeAventuriers.size(); i++) {
			listeAventuriers.get(i);
		}

		return 0;
	}

}
