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
	 */
	public static Gladiateur ajouterMirmillon(String pNom, int pPoids) {
		tousLesGladiateurs.add(new Mirmillon(GGladiateur.nextIdGladiateur++,pNom,pPoids));
		return tousLesGladiateurs.get(tousLesGladiateurs.size()-1);
	}
	
	/**
	 * Ajoute un gladiateur de type Mirimillon � la lste des gladiateurs
	 * @param pNom nom du gladiateur
	 * @param pAgilite son agilit�
	 * @return l'objet gladiateur cr�er
	 */
	public static Gladiateur ajouterRetiaire(String pNom, int pAgilite) {
		tousLesGladiateurs.add(new Retiaire(GGladiateur.nextIdGladiateur++,pNom,pAgilite));
		return tousLesGladiateurs.get(tousLesGladiateurs.size()-1);
	}
	
	/**
	 * M�thode qui renvoie l'ensembles des gladiateurs en jeu
	 * @return Liste de gladiateurs "ArrayList<Gladiateur>()"
	 */
	public static ArrayList<Gladiateur> getTousLesGladiateurs() {
		return tousLesGladiateurs;
	}
	
	/**
	 * Retourne le gladiateur dont l'id est pass� en param�tre
	 * @param pIdGladiateur
	 * @return Gladiateur
	 */
	public static Gladiateur getGladiateur(int pIdGladiateur) {
		for(Gladiateur gladiateur : tousLesGladiateurs) {
			if(gladiateur.getIdGladiateur()==pIdGladiateur) {
				return gladiateur;
			}
		}
		return null;
	}
	
	/**
	 * Supprime de la liste des gladiateurs le gladiateur correspondant � l'id
	 * @param pIdGladiateur
	 */
	public static  void supprimerGladiateur(int pIdGladiateur) {
		Gladiateur gladiateur = getGladiateur(pIdGladiateur);
		tousLesGladiateurs.remove(gladiateur);
	}
	
	
	/**
	 * Supprime de la liste des gladiateurs le gladiateur passer en parametre
	 * @param pGladiateur
	 */
	public static void supprimerGladiateur(Gladiateur pGladiateur) {
		tousLesGladiateurs.remove(pGladiateur);
	}
	
}
