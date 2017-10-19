package vue;

import java.util.Scanner;

import controlleur.CColiseeConsole;
import controlleur.Facade;
import modele.ReadXMLFile;

public class ColiseeConsole {
	private static Scanner scan;
	private static String filepath;

	public static void main(String[] args) {
		//filepath = getFilePath();
		CColiseeConsole coliseeconsole = new CColiseeConsole();
		coliseeconsole.chargerJeuDEssai();
		try {
			CColiseeConsole.lancerCombat();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ReadXMLFile.main(args);
	}
	/*
	public static String getFilePath()
	{
		
	    String reponse = "";
	    scan = new Scanner(System.in);
	    int erreur = 0;
	    int p = 0;
	    do
	    {
	    	System.out.print("Veuillez saisir le chemin de votre fichier contenant le jeu d'essai");
	        reponse = scan.nextLine();
	        try
	        {
	            p=Integer.parseInt(reponse);
	        }
	        catch (NumberFormatException e)
	        {
	            erreur = 0;
	        }
	         
	        if (erreur == 1)
	        {
	            System.out.println("Veuillez rentrer le chemin de votre fichier contenant le jeu d'essai");
	        }
	             
	    } while (erreur == 1);
	    return reponse;
	}*/
	
}
