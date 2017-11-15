/**
 * 
 */
package controlleur;

import java.util.ArrayList;

import modele.Gladiateur;
import modele.Mirmillon;
import modele.Retiaire;

/**
 * @author clement
 * 
 * Gestionnaire de Gladiateurs
 */
public class GGladiateur {
	
	// variable de classe
	private static int nextIdGladiateur = 1;
	private static ArrayList<Gladiateur> tousLesGladiateurs;
	
	/***
	 * Constructeur du gestionnaire
	 */
	public GGladiateur() {
		tousLesGladiateurs = new ArrayList<Gladiateur>();
	};
	
	/**
	 * Ajoute un gladiateur de type Mirimillon � la lste des gladiateurs
	 * @param pNom nom du gladiateur
	 * @param pPoids son poids
	 * @return l'objet gladiateur cr�er
	 * @throws Exception 
	 */
	public static Gladiateur ajouterMirmillon(String pNom, int pPoids) throws Exception {
		tousLesGladiateurs.add(new Mirmillon(GGladiateur.nextIdGladiateur++,pNom,pPoids));
		return tousLesGladiateurs.get(tousLesGladiateurs.size()-1);
	}
	
	/**
	 * Ajoute un gladiateur de type Mirimillon � la lste des gladiateurs
	 * @param idGladiateur Id du gladiateur a creer
	 * @param pNom nom du gladiateur
	 * @param pPoids son poids
	 * @return l'objet gladiateur cr�er
	 * @throws Exception 
	 */
	public static Gladiateur ajouterMirmillon(int idGladiateur, String pNom, int pPoids) throws Exception {
		tousLesGladiateurs.add(new Mirmillon(idGladiateur,pNom,pPoids));
		return tousLesGladiateurs.get(tousLesGladiateurs.size()-1);
	}
	
	/**
	 * Ajoute un gladiateur de type Mirimillon � la lste des gladiateurs
	 * @param pNom nom du gladiateur
	 * @param pAgilite son agilit�
	 * @return l'objet gladiateur cr�er
	 * @throws Exception 
	 */
	public static Gladiateur ajouterRetiaire(String pNom, int pAgilite) throws Exception {
		tousLesGladiateurs.add(new Retiaire(GGladiateur.nextIdGladiateur++,pNom,pAgilite));
		return tousLesGladiateurs.get(tousLesGladiateurs.size()-1);
	}
	
	/**
	 * Ajoute un gladiateur de type Mirimillon � la lste des gladiateurs
	 * @param idGladiateur Id du gladiateur a ajouter
	 * @param pNom nom du gladiateur
	 * @param pAgilite son agilit�
	 * @return l'objet gladiateur cr�er
	 * @throws Exception 
	 */
	public static Gladiateur ajouterRetiaire(int idGladiateur, String pNom, int pAgilite) throws Exception {
		tousLesGladiateurs.add(new Retiaire(idGladiateur,pNom,pAgilite));
		return tousLesGladiateurs.get(tousLesGladiateurs.size()-1);
	}
	
	/**
	 * Mehode qui renvoie l'ensembles des gladiateurs en jeu
	 * @return ArrayList Liste de gladiateurs
	 */
	public static ArrayList<Gladiateur> getTousLesGladiateurs() {
		return tousLesGladiateurs;
	}
	
	/**
	 * Retourne le gladiateur dont l'id est pass� en param�tre
	 * @param pIdGladiateur Id du gladiateur a recuperer
	 * @return Gladiateur
	 */
	public static Gladiateur getGladiateur(int pIdGladiateur) {
		System.out.println(pIdGladiateur);
		for(Gladiateur gladiateur : tousLesGladiateurs) {
			if(gladiateur.getIdGladiateur()==pIdGladiateur) {
				return gladiateur;
			}
		}
		return null;
	}
	
	/**
	 * Supprime de la liste des gladiateurs le gladiateur correspondant � l'id
	 * @param pIdGladiateur Id du gladiateur a supprimer
	 */
	public static  void supprimerGladiateur(int pIdGladiateur) {
		Gladiateur gladiateur = getGladiateur(pIdGladiateur);
		tousLesGladiateurs.remove(gladiateur);
	}
	
	
	/**
	 * Supprime de la liste des gladiateurs le gladiateur passer en parametre
	 * @param pGladiateur Objet gladiateur a supprimer
	 */
	public static void supprimerGladiateur(Gladiateur pGladiateur) {
		tousLesGladiateurs.remove(pGladiateur);
	}
	
}
