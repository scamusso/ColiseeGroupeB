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
	private ArrayList<Gladiateur> lesGladiateurs;
	
	/***
	 * Constructeur du gestionnaire
	 */
	public GGladiateur() {
		this.lesGladiateurs = new ArrayList<Gladiateur>();
	};
	
	/**
	 * Ajoute un gladiateur de type Mirimillon � la lste des gladiateurs
	 * @param pNom nom du gladiateur
	 * @param pPoids son poids
	 * @return l'objet gladiateur cr�er
	 */
	public Gladiateur ajouterMirmillon(String pNom, int pPoids) {
		this.lesGladiateurs.add(new Mirmillon(GGladiateur.nextIdGladiateur++,pNom,pPoids));
		return this.lesGladiateurs.get(this.lesGladiateurs.size()-1);
	}
	
	/**
	 * Ajoute un gladiateur de type Mirimillon � la lste des gladiateurs
	 * @param pNom nom du gladiateur
	 * @param pAgilite son agilit�
	 * @return l'objet gladiateur cr�er
	 */
	public Gladiateur ajouterRetiaire(String pNom, int pAgilite) {
		this.lesGladiateurs.add(new Retiaire(GGladiateur.nextIdGladiateur++,pNom,pAgilite));
		return this.lesGladiateurs.get(this.lesGladiateurs.size()-1);
	}
	
	/**
	 * M�thode qui renvoie l'ensembles des gladiateurs en jeu
	 * @return Liste de gladiateurs "ArrayList<Gladiateur>()"
	 */
	public ArrayList<Gladiateur> getTousLesGladiateurs() {
		return this.lesGladiateurs;
	}
	
	/**
	 * Retourne le gladiateur dont l'id est pass� en param�tre
	 * @param pIdGladiateur
	 * @return Gladiateur
	 */
	public Gladiateur getGladiateur(int pIdGladiateur) {
		for(Gladiateur gladiateur : this.lesGladiateurs) {
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
	public void supprimerGladiateur(int pIdGladiateur) {
		for(Gladiateur gladiateur : this.lesGladiateurs) {
			if(gladiateur.getIdGladiateur()==pIdGladiateur) {
				this.lesGladiateurs.remove(gladiateur);
			}
		}
	}
	
	
	/**
	 * Supprime de la liste des gladiateurs le gladiateur passer en parametre
	 * @param pGladiateur
	 */
	public void supprimerGladiateur(Gladiateur pGladiateur) {
		this.lesGladiateurs.remove(pGladiateur);
	}
	
}
