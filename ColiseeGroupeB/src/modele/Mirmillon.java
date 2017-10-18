package modele;

import java.util.ArrayList;

/**
 * Mirmillon est la classe représentante un gladiateur de type mirmillon dans le colysée.
 * 
 * @author Stephane CAMUSSO
 * 
 */


public class Mirmillon extends Gladiateur {
	
	private int poids;
	private static String cType;
	private ArrayList<Gladiateur> agresseurs;
	
	/**
	 * 
	 * Constructeur de Mirmillon
	 * 
	 * @param idGladiateur
	 * @param nomGladiateur
	 * @param agilite
	 */
	public Mirmillon(int idGladiateur, String nomGladiateur, int poids) {
		super(idGladiateur, nomGladiateur);
		this.poids = poids;
		Mirmillon.cType = "Mirmillon";
		this.agresseurs = new ArrayList<Gladiateur>();
	}
	
	
	/**
	 * 
	 * Permet au gladiateur de faire un rapport sur lui meme
	 * Ajout des agresseurs pour le mirmillon
	 * 
	 * @return rapport
	 */
	
	public String rapport() {
		String rapport = super.rapport();
		rapport = rapport + " " + agresseurs ;
		return (rapport);
	}	
	
	/**
	 * 
	 * Permet de descendre la vie du gladiateur en fonction de la force du coup recu
	 * On enregistre aussi l'agresseur pour pouvoir restituer la liste en cas de besoin
	 * Pour le Mirmillon, on enregistre l'agresseur
	 * 
	 * @param agresseur
	 * @param forceCoup
	 */
	public void recevoirCoup(Gladiateur agresseur, int forceCoup) {
		super.recevoirCoup(agresseur, forceCoup);
		agresseurs.add(agresseur);

	}
	
	//Getters

	public int getPoids() {
		return poids;
	}

	public int getForce() {
		return poids/2;
	}

	public ArrayList<modele.Gladiateur> getMesAggresseurs() {
		return agresseurs;
	}
	
	public String getType() {
		return cType;
	}

	//Setters
	
	public void setCType() {
		Mirmillon.cType = "Mirmillon";
	}

}
