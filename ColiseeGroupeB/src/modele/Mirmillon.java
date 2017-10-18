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
	private static String cType = "Mirmillon";
	private ArrayList<Gladiateur> mesAgresseurs;
	
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
		this.setMesAgresseurs(new ArrayList<Gladiateur>());
	}
	
	
	/**
	 * 
	 * Permet au gladiateur de faire un rapport sur lui meme
	 * Ajout des mesAgresseurs pour le mirmillon
	 * 
	 * @return rapport
	 */
	
	public String rapport() {
		String rapport = super.rapport();
		rapport = rapport + " " + getMesAgresseurs() ;
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
		getMesAgresseurs().add(agresseur);

	}
	
	//Getters

	public int getPoids() {
		return poids;
	}

	public int getForce() {
		return poids/2;
	}

	public ArrayList<modele.Gladiateur> getMesAggresseurs() {
		return mesAgresseurs;
	}
	
	public String getType() {
		return cType;
	}

	//Setters
	
	public static void setCType(String cType) {
		Mirmillon.cType = cType;
	}


	public ArrayList<Gladiateur> getMesAgresseurs() {
		return mesAgresseurs;
	}


	public void setMesAgresseurs(ArrayList<Gladiateur> mesAgresseurs) {
		this.mesAgresseurs = mesAgresseurs;
	}

}
