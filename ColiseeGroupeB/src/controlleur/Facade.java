/**
 * 
 */
package controlleur;

import java.util.ArrayList;

import modele.Arme;
import modele.Gladiateur;

/**
 * @author clement
 * Controlleur permettant la gestion des �v�nement li�e aux Gladiateurs
 */
public class Facade {
	
	// Variable de classe
	private GGladiateur gGladiateur;
	private GArme gArme;
	
	/**
	 * Constructeur
	 */
	public Facade() {
		this.gGladiateur = new GGladiateur();
		this.gArme=new GArme();
	}
	
	/**
	 * Creer un Retiaire dans la partie
	 * @param pNom nom du gladiateur
	 * @param pAgilite agilit� du gladiateur
	 * @return le gladiateur cr�er
	 */
	public Gladiateur creerRetiaire(String pNom, int pAgilite) {
		return this.gGladiateur.ajouterRetiaire(pNom, pAgilite);
	}
	
	/**
	 * Cr�er un Mirmillon dans la partie
	 * @param pNom nom du gladiateur
	 * @param pAgilite agilit� du gladiateur
	 * @return le gladiateur cr�er
	 */
	public Gladiateur creerMirmillon(String pNom, int pPoids) {
		return this.gGladiateur.ajouterMirmillon(pNom, pPoids);
	}
	
	/**
	 * @return la liste des gladiateurs
	 */
	public ArrayList<Gladiateur> listertousLesGladiateurs() {
		return this.gGladiateur.getTousLesGladiateurs();
	}
	
	/**
	 * Retourne la liste des agresseur du gladiateur dont l'id est pass� en param�tre
	 * @param pIdGladiateur
	 * @return liste des gladiateurs (objet) 
	 */
	public ArrayList<Gladiateur> listerAgresseurs(int pIdGladiateur) {
		return this.gGladiateur.getGladiateur(pIdGladiateur).getMesAggresseurs();	
	}
	
	/**
	 * Renvoie une cha�ne de carract�re
	 * @param pIdGladiateur
	 * @return String 
	 */
	public String faireSaluerGladiateur(int pIdGladiateur) {
		return this.gGladiateur.getGladiateur(pIdGladiateur).saluer();
	}
	
	/**
	 * Retourne le rapport du gladiateur dont l'id est pass� en param�tre
	 * @param pIdGladiateur
	 * @return String
	 */
	public String faireRapport(int pIdGladiateur) {
		return this.gGladiateur.getGladiateur(pIdGladiateur).rapport();
	}
	
	/**
	 * Retourne les armes du gladiateur dont l'id est pass� en param�tre
	 * @param pIdGladiateur
	 * @return ArrayList<Arme>
	 */
	public ArrayList<Arme> declarerArmes(int pIdGladiateur) {
		return this.gGladiateur.getGladiateur(pIdGladiateur).getMesArmes();
	}
	
	
	/**
	 * Supprime le gladiateur dont l'id est pass� en param�tre
	 * @param pIdGladiateur : int
	 */
	public void supprimerGladiateur(int pIdGladiateur) {
		this.gGladiateur.supprimerGladiateur(pIdGladiateur);
	}
	
	/**
	 * Cr�ation d'une nouvelle arme	
	 * @param pNom : String
	 * @param pPuissOff : int
	 * @param pPuissDef : int
	 * @return Arme
	 */
	public Arme creerUneArme(String pNom, int pPuissOff, int pPuissDef) {
		return this.gArme.ajouterArme(pNom, pPuissOff, pPuissDef);
	}
	
	
	/**
	 * Affectation d'une arme � un gladiateur
	 * @param pIdGladiateur : int
	 * @param pIdArme : int
	 */
	public void donnerUneArme(int pIdGladiateur, int pIdArme) {
		this.gGladiateur.getGladiateur(pIdGladiateur).recevoirArme(this.gArme.getArme(pIdArme));
	}
	
	/**
	 * Retourne la description d'une arme en fonction de l'id pass� en param�tre
	 * @param pIdArme
	 * @return String
	 */
	public String decrireArme(int pIdArme) {
		return this.gArme.getArme(pIdArme).description();
	}
	
	/**
	 * Renvoie le nom de l'arme dont l'id est pass� en param�tre
	 * @param pIdArme
	 * @return String
	 */
	public String nomArme(int pIdArme) {
		return this.gArme.getArme(pIdArme).getNomArme();
	}
	
	/**
	 * Methode qui permet de lancer l'action frapper
	 * @param pIdAgresseur : int
	 * @param pIdVictime : int
	 * @param pIdArme: int
	 */
	public void frapper(int pIdAgresseur, int pIdVictime, int pIdArme) {
		if(!this.gGladiateur.getGladiateur(pIdAgresseur).estMoribond() && ! this.gGladiateur.getGladiateur(pIdVictime).estMoribond()) {
			this.gGladiateur.getGladiateur(pIdAgresseur).frapper(this.gGladiateur.getGladiateur(pIdVictime), this.gArme.getArme(pIdArme));
		}
	}
	
}
