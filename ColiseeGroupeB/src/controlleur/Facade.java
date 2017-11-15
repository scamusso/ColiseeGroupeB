/**
 * 
 */
package controlleur;

import java.util.ArrayList;

import modele.Arme;
import modele.Gladiateur;

/**
 * @author clement
 * Controleur permettant la gestion des evenement liee aux Gladiateurs
 */
public class Facade {

	// Variable de classe
	protected static GGladiateur gGladiateur;
	protected static GArme gArme;


	/**
	 * Constructeur
	 */
	public  Facade() {
		gGladiateur = new GGladiateur();
		gArme=new GArme();
	}

	/**
	 * Creer un Retiaire dans la partie
	 * @param pNom nom du gladiateur
	 * @param pAgilite agilite du gladiateur
	 * @return le gladiateur creer
	 * @throws Exception leve une erreur si l'agilite pAgilite d'un Retiaire est negative 
	 */
	public static Gladiateur creerRetiaire(String pNom, int pAgilite) throws Exception {
		return gGladiateur.ajouterRetiaire(pNom, pAgilite);
	}

	/**
	 * Creer un Mirmillon dans la partie
	 * @param pNom nom du gladiateur
	 * @param pPoids poid du gladiateur
	 * @return le gladiateur creer
	 * @throws Exception Leve une erreur si le poid d'un Mirmillon est inferieur ou egal a 0, et si la liste des agresseurs est null
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
	 * Retourne la liste des agresseur du gladiateur dont l'id est passe en parametre
	 * @param pIdGladiateur ID du gladiateur dont on veut connaitre la liste des agresseurs
	 * @return liste des gladiateurs (objet) 
	 */
	public static ArrayList<Gladiateur> listerAgresseurs(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			return gGladiateur.getGladiateur(pIdGladiateur).getMesAggresseurs();	
		}
		return null;
	}

	/**
	 * Renvoie une chaine de caracteres
	 * @param pIdGladiateur ID du gladiateur que l'on veut faire saluer
	 * @return String 
	 */
	public static String faireSaluerGladiateur(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			return gGladiateur.getGladiateur(pIdGladiateur).saluer();
		}
		return null;
	}

	/**
	 * Retourne le rapport du gladiateur dont l'id est passe en parametre
	 * @param pIdGladiateur ID du gladiateur qui doit faire son rapport
	 * @return String
	 */
	public static String faireRapport(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			return gGladiateur.getGladiateur(pIdGladiateur).rapport();
		}
		return null;
	}

	/**
	 * Retourne les armes du gladiateur dont l'id est passe en parametre
	 * @param pIdGladiateur ID du gladiateur qui doit declarer ses armes
	 * @return ArrayList des Armes
	 */
	public static ArrayList<Arme> declarerArmes(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			return gGladiateur.getGladiateur(pIdGladiateur).getMesArmes();
		}
		return null;
	}


	/**
	 * Supprime le gladiateur dont l'id est passe en parametre
	 * @param pIdGladiateur : int
	 */
	public static void supprimerGladiateur(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			gGladiateur.supprimerGladiateur(pIdGladiateur);
		}
	}

	/**
	 * Crï¿½ation d'une nouvelle arme	
	 * @param pNom : String
	 * @param pPuissOff : int
	 * @param pPuissDef : int
	 * @return Arme
	 * @throws Exception Leve une exception si : 
	 * 				L'id de l'arme est inferieur ou egal à 0
	 * 				Le nom de l'arme est vide
	 * 				La puissance offensive d'une arme est inferieur a 0
	 * 				La puissance defensive d'une arme est inferieur a 0
	 */
	public static Arme creerUneArme(String pNom, int pPuissOff, int pPuissDef) throws Exception {
		return gArme.ajouterArme(pNom, pPuissOff, pPuissDef);
	}


	/**
	 * Affectation d'une arme a un gladiateur
	 * @param pIdGladiateur : int id du gladiateur qui doit recevoir une arme
	 * @param pIdArme : int Id de l'arme a donner au gladiateur
	 * @throws Exception Leve une exception si le gladiateur recoit une arme null
	 */
	public static void donnerUneArme(int pIdGladiateur, int pIdArme) throws Exception {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			gGladiateur.getGladiateur(pIdGladiateur).recevoirArme(gArme.getArme(pIdArme));
		}
	}

	/**
	 * Retourne la description d'une arme en fonction de l'id passe en parametre
	 * @param pIdArme Id de l'arme que le gladiateur doit decrire
	 * @return String
	 */
	public static String decrireArme(int pIdArme) {
		if (gArme.getArme(pIdArme) !=  null){
			return gArme.getArme(pIdArme).description();
		}
		return null;
	}

	/**
	 * Renvoie le nom de l'arme dont l'id est passe en parametre
	 * @param pIdArme Id de l'arme en question
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
	 * @throws Exception Leve une exception si
	 * 				 le Gladiateur reçoit un coup avec une Force negative ou reçoit un coup d'un Gladiateur inexistant
	 */
	public static void frapper(int pIdAgresseur, int pIdVictime, int pIdArme) throws Exception {
		if(!gGladiateur.getGladiateur(pIdAgresseur).estMoribond() && ! gGladiateur.getGladiateur(pIdVictime).estMoribond()) {
			gGladiateur.getGladiateur(pIdAgresseur).frapper(gGladiateur.getGladiateur(pIdVictime), gArme.getArme(pIdArme));
		}
	}

}
