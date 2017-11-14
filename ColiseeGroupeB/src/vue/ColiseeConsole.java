package vue;

import java.util.Scanner;

import controlleur.CColiseeConsole;
import controlleur.Facade;
import modele.ReadXMLFile;

/**
 * Demarrage de la gestion automatisée des combats entre gladiateurs
 * @author Aline.FRIERA
 *
 */
public class ColiseeConsole {
	private static Scanner scan;
	private static String filepath;

	
	public static void main(String[] args) {
		
		String filepath;
		try{
			
			filepath = args[0];
		}catch(Exception e){
			
			filepath = Menu.verifierSaisieString("Veuillez saisir le chemin du fichier de jeu d'essai :\n");
		}
		
		System.out.println("chemin entré : "+filepath);
		
		CColiseeConsole coliseeconsole = new CColiseeConsole();
		
		//Charge le jeu d'essai a partir du fichier XML transmit en paramètre
		coliseeconsole.chargerJeuDEssai(filepath);
		
		//Début du combat
		try {
			CColiseeConsole.lancerCombat();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
