/**
 * 
 */
package vue;

import java.util.Scanner;

import controlleur.Facade;
import modele.Gladiateur;

/**
 * @author root
 *
 */
public class Menu {

	private static Scanner scan;
	private static Scanner scan2;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		afficherMenu();

	}
	
	public static void afficherMenu() {
		
		boolean fin = false;
		
		// initialisation des jeux de données
		Facade partie = new Facade();
		
		while(!fin) {
			System.out.println("Bienvenu dans le jeu des gladiateur"); 
			
			System.out.println("0.	Lancer le jeu d'essai initial ci-dessous (6 armes, 6 gladiateurs avec leur équipement)");
			System.out.println("1.	Créer un rétiaire (avec son nom, son agilité)");
			System.out.println("2.	Créer un mirmillon (avec son nom, son poids)");
			System.out.println("3.	Créer une arme (avec son nom, sa puissanceOff, sa puissanceDef");
			System.out.println("4.	(Début du combat) : Lister tous les gladiateurs : salut et armes");
			System.out.println("5.	Afficher le rapport du gladiateur d'identifiant idg");
			System.out.println("6.	Donner une arme ida au gladiateur idg");
			System.out.println("7.	Frapper (avec idg de l'agresseur, idg de l'agressé, ida de l'arme utilisée)");
			System.out.println("8.	Supprimer du jeu le gladiateur idg");
			System.out.println("999.Quitter le jeu\n");
			
			
			
			
			switch(verifierSaisieInt("Choix")) {
				case 0 :
					partie.lancerJeuDEssai();
				break;
				case 1 :
					System.out.println("Veuillez rentrer les informations pour créer un rétiare");
					partie.creerRetiaire(verifierSaisieString("nom : "), verifierSaisieInt("Agilite :"));
				break;
				case 2 :
					System.out.println("Veuillez rentrer les informations pour créer un mirmillon");
					partie.creerMirmillon(verifierSaisieString("nom : "), verifierSaisieInt("Poids :"));
				break;
				case 3 :
					System.out.println("Veuillez rentrer les informations pour créer une arme");
					partie.creerUneArme(verifierSaisieString("nom : "), verifierSaisieInt("Puissance Offensive : "), verifierSaisieInt("Puissance défensive :"));
				break;
				case 4 :
					for(Gladiateur gladiateur : partie.listerTousLesGladiateurs ()) {
						System.out.println(gladiateur.saluer());
						gladiateur.declarerMesArmes();
					}
				break;
				case 5 :
					System.out.println(partie.faireRapport(verifierSaisieInt("Saisir identifiant du gladiateur")));
				break;
				case 6 :
					partie.donnerUneArme(verifierSaisieInt("Saisir identifiant du gladiateur"), verifierSaisieInt("Saisir identifiant de l'arme"));
				break;
				case 7 :
					partie.frapper(verifierSaisieInt("Saisir identifiant de l'agresseur"), verifierSaisieInt("Saisir identifiant de la victime"), verifierSaisieInt("Saisir identifiant de l'arme"));
				break;
				case 8 :
					partie.supprimerGladiateur(verifierSaisieInt("Saisir identifiant du gladiateur"));
				break;
				case 9 :
					for(Gladiateur gladiateur : partie.listerTousLesGladiateurs ()) {
						if(!gladiateur.estMoribond()) {
							System.out.println(gladiateur.saluer());
							System.out.println(gladiateur.declarerMesArmes());
						}
					}
				break;
				case 999 :
					fin = true;
				break;
				default : System.out.println("Veuillez saisir un choix : ");
			
			}
		}
		
	}
	
	/**
	 * Controle de saisie
	 * @return la saisie controller
	 */
	public static int verifierSaisieInt(String pTxt)
	{
	    String reponse = "";
	    scan = new Scanner(System.in);
	    int erreur = 0;
	    int p = 0;
	    do
	    {
	    	System.out.print(pTxt);
	        reponse = scan.nextLine();
	        try
	        {
	            p=Integer.parseInt(reponse);
	            erreur = 0;
	        }
	        catch (NumberFormatException e)
	        {
	            erreur = 1;
	        }
	         
	        if (erreur == 1)
	        {
	            System.out.println("Veuillez rentrer un eniter");
	        }
	             
	    } while (erreur == 1);
	    return p;
	}
	
	
	/**
	 * Controle de saisie
	 * @return la saisie controller
	 */
	public static String verifierSaisieString(String pTxt)
	{
	    String reponse = "";
	    scan2 = new Scanner(System.in);
	    int erreur = 0;
	    int p = 0;
	    do
	    {
	    	System.out.print(pTxt);
	        reponse = scan2.nextLine();
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
	            System.out.println("Veuillez rentrer une chaîne de caractère");
	        }
	             
	    } while (erreur == 1);
	    return reponse;
	}
	
	

	
	
	
}
