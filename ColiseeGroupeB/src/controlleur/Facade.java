/**
 * 
 */
package controlleur;

import java.util.ArrayList;

import modele.Arme;
import modele.Gladiateur;

/**
 * @author clement
 * Controleur permettant la gestion des �v�nement li�e aux Gladiateurs
 */
public class Facade {

	// Variable de classe
	private static GGladiateur gGladiateur;
	private static GArme gArme;

	/**
	 * Constructeur
	 */
	public  Facade() {
		gGladiateur = new GGladiateur();
		gArme=new GArme();
	}



	/**
	 *  Initialise le jeu d'essai
	 * @throws Exception 
	 */
	public static void lancerJeuDEssai() throws Exception {
		creerRetiaire("Unix", 30);
		creerMirmillon("Infomatix", 100);
		creerRetiaire("Ceplusplus", 40);
		creerMirmillon("Pythonus", 60);
		creerRetiaire("Szervlet", 50);
		creerMirmillon("Ramazmjet", 80);
		//Créer les armes
		creerUneArme("Glaive", 80, 0);
		creerUneArme("trident", 100, 0);
		creerUneArme("Filet", 40, 20);
		creerUneArme("Bouclier", 40, 40);
		creerUneArme("Casque", 0, 20);
		creerUneArme("Jambière", 0, 10);
		donnerUneArme(1, 2);
		donnerUneArme(1, 6);
		donnerUneArme(1, 3);
		donnerUneArme(2, 1);
		donnerUneArme(2, 4);
		donnerUneArme(2, 5);
		donnerUneArme(2, 6);	
		donnerUneArme(3, 2);
		donnerUneArme(3, 6);
		donnerUneArme(4, 1);
		donnerUneArme(4, 4);
		donnerUneArme(5, 1);
		donnerUneArme(5, 6);
		donnerUneArme(6, 4);
		donnerUneArme(6, 5);
	}

	/**
	 * Creer un Retiaire dans la partie
	 * @param pNom nom du gladiateur
	 * @param pAgilite agilit� du gladiateur
	 * @return le gladiateur cr�er
	 * @throws Exception 
	 */
	public static Gladiateur creerRetiaire(String pNom, int pAgilite) throws Exception {
		return gGladiateur.ajouterRetiaire(pNom, pAgilite);
	}

	/**
	 * Cr�er un Mirmillon dans la partie
	 * @param pNom nom du gladiateur
	 * @param pAgilite agilit� du gladiateur
	 * @return le gladiateur cr�er
	 * @throws Exception 
	 */
	public static Gladiateur creerMirmillon(String pNom, int pPoids) throws Exception {
		return gGladiateur.ajouterMirmillon(pNom, pPoids);
	}

	/**
	 * @return la liste des gladiateurs
	 */
	public static ArrayList<Gladiateur> listerTousLesGladiateurs () {
		return gGladiateur.getTousLesGladiateurs();
	}

	/**
	 * Retourne la liste des agresseur du gladiateur dont l'id est pass� en param�tre
	 * @param pIdGladiateur
	 * @return liste des gladiateurs (objet) 
	 */
	public static ArrayList<Gladiateur> listerAgresseurs(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			return gGladiateur.getGladiateur(pIdGladiateur).getMesAggresseurs();	
		}
		return null;
	}

	/**
	 * Renvoie une cha�ne de carract�re
	 * @param pIdGladiateur
	 * @return String 
	 */
	public static String faireSaluerGladiateur(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			return gGladiateur.getGladiateur(pIdGladiateur).saluer();
		}
		return null;
	}

	/**
	 * Retourne le rapport du gladiateur dont l'id est pass� en param�tre
	 * @param pIdGladiateur
	 * @return String
	 */
	public static String faireRapport(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			return gGladiateur.getGladiateur(pIdGladiateur).rapport();
		}
		return null;
	}

	/**
	 * Retourne les armes du gladiateur dont l'id est pass� en param�tre
	 * @param pIdGladiateur
	 * @return ArrayList<Arme>
	 */
	public static ArrayList<Arme> declarerArmes(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			return gGladiateur.getGladiateur(pIdGladiateur).getMesArmes();
		}
		return null;
	}


	/**
	 * Supprime le gladiateur dont l'id est pass� en param�tre
	 * @param pIdGladiateur : int
	 */
	public static void supprimerGladiateur(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			gGladiateur.supprimerGladiateur(pIdGladiateur);
		}
	}

	/**
	 * Cr�ation d'une nouvelle arme	
	 * @param pNom : String
	 * @param pPuissOff : int
	 * @param pPuissDef : int
	 * @return Arme
	 * @throws Exception 
	 */
	public static Arme creerUneArme(String pNom, int pPuissOff, int pPuissDef) throws Exception {
		return gArme.ajouterArme(pNom, pPuissOff, pPuissDef);
	}


	/**
	 * Affectation d'une arme � un gladiateur
	 * @param pIdGladiateur : int
	 * @param pIdArme : int
	 * @throws Exception 
	 */
	public static void donnerUneArme(int pIdGladiateur, int pIdArme) throws Exception {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			gGladiateur.getGladiateur(pIdGladiateur).recevoirArme(gArme.getArme(pIdArme));
		}
	}

	/**
	 * Retourne la description d'une arme en fonction de l'id pass� en param�tre
	 * @param pIdArme
	 * @return String
	 */
	public static String decrireArme(int pIdArme) {
		if (gArme.getArme(pIdArme) !=  null){
			return gArme.getArme(pIdArme).description();
		}
		return null;
	}

	/**
	 * Renvoie le nom de l'arme dont l'id est pass� en param�tre
	 * @param pIdArme
	 * @return String
	 */
	public static String nomArme(int pIdArme) {
		if (gArme.getArme(pIdArme) !=  null){
			return gArme.getArme(pIdArme).getNomArme();
		}
		return null;
	}

	/**
	 * Methode qui permet de lancer l'action frapper
	 * @param pIdAgresseur : int
	 * @param pIdVictime : int
	 * @param pIdArme: int
	 * @throws Exception 
	 */
	public static void frapper(int pIdAgresseur, int pIdVictime, int pIdArme) throws Exception {
		if(!gGladiateur.getGladiateur(pIdAgresseur).estMoribond() && ! gGladiateur.getGladiateur(pIdVictime).estMoribond()) {
			gGladiateur.getGladiateur(pIdAgresseur).frapper(gGladiateur.getGladiateur(pIdVictime), gArme.getArme(pIdArme));
		}
	}

}
