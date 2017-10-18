package modele;

import java.util.ArrayList;

/**
 * Retiaire est la classe représentante un gladiateur de type retiaire dans le colysée.
 * 
 * @author Stephane CAMUSSO
 * 
 */

public class Retiaire extends Gladiateur  {


	private static int cForce = 30;
	private static String cType = "Retiaire";
	private int agilite;
	
	/**
	 * 
	 * Constructeur de Retiaire
	 * 
	 * @param idGladiateur
	 * @param nomGladiateur
	 * @param agilite
	 */
	public Retiaire(int idGladiateur, String nomGladiateur, int agilite) {
		super(idGladiateur, nomGladiateur);
		this.setAgilite(agilite);
	}
	
	/**
	 * 
	 * Permet de descendre la vie du gladiateur en fonction de la force du coup recu
	 * On enregistre aussi l'agresseur pour pouvoir restituer la liste en cas de besoin
	 * Pour le Retiaire, on deduit les points d'agilité aux degats recus
	 * 
	 * @param agresseur
	 * @param forceCoup
	 */
	public void recevoirCoup(Gladiateur agresseur, int forceCoup) {
		super.recevoirCoup(agresseur, forceCoup);
	}
	
	/**
	 * 
	 * Permet au gladiateur de faire un rapport sur lui meme
	 * Ajout de l'agilité pour le retiaire
	 * 
	 * @return rapport
	 */
	
	public String rapport() {
		String rapport = super.rapport();
		int attribuType;
		attribuType = this.getAgilite() ;
		rapport = rapport + " " + attribuType ;
		return (rapport);
	}	
	
	//Getters
	
	public int getAgilite() {
		return agilite;
	}

	public int getForce() {
		return cForce ;
	}

	public String getType() {
		return cType;
	}
	
	
	//Setters
	
	private void setCType() {
		Retiaire.cType = "Retiaire";
	}
	
	private static int getCForce() {
		return cForce;
	}

	private static void setCForce(int cForce) {
		Retiaire.cForce = cForce;
	}

	private static String getCType() {
		return cType;
	}

	private static void setCType(String cType) {
		Retiaire.cType = cType;
	}


	private void setAgilite(int agilite) {
		this.agilite = agilite;
	}

	@Override
	public ArrayList<Gladiateur> getMesAggresseurs() {
		return null;
	}


	



}
