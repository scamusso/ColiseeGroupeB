package vue;

import java.util.Scanner;

import controlleur.CColiseeConsole;
import controlleur.Facade;
import modele.ReadXMLFile;

/**
 * Demarrage de la gestion automatis�e des combats entre gladiateurs
 * @author Aline.FRIERA
 *
 */
public class ColiseeConsole {
	private static Scanner scan;
	private static String filepath;

	
	public static void main(String[] args) {
		
		
		String filepath = Menu.verifierSaisieString("Veuillez saisir le chemin du fichier de jeu d'essai :\n");
		
		System.out.println("chemin entr� : "+filepath);
		
		//  C:\Users\Aline.FRIERA\git\ColiseeGroupeB\ColiseeGroupeB\jeuDEssai2.xml
		
		//String filepath = "jeuDEssai2.xml";
		
		CColiseeConsole coliseeconsole = new CColiseeConsole();
		
		//Charge le jeu d'essai a partir du fichier XML transmit en param�tre
		coliseeconsole.chargerJeuDEssai(filepath);
		
		//D�but du combat
		try {
			CColiseeConsole.lancerCombat();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
