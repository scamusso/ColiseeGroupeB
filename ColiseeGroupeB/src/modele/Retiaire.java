package modele;

import java.util.ArrayList;

import modele.Exception.ExceptionRetiaire;

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
	public Retiaire(int idGladiateur, String nomGladiateur, int agilite) throws Exception{
		super(idGladiateur, nomGladiateur);
		if(agilite <0)  {
			throw new ExceptionRetiaire("L'agilité d'un Rétiaire ne peut pas être négative !");			
		}
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
	public void recevoirCoup(Gladiateur agresseur, int forceCoup) throws Exception {
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
		return super.rapport() + " " + this.getAgilite();
	}	
	
	//Getters
	
	public int getAgilite() {
		return this.agilite;
	}

	public int getForce() {
		return Retiaire.cForce ;
	}

	public String getType() {
		return Retiaire.cType;
	}
	
	
	//Setters	
	private static int getCForce() {
		return Retiaire.cForce;
	}

	private static void setCForce(int cForce) throws Exception {
		if(cForce < 0) {
			throw new ExceptionRetiaire("La force d'un Retiaire ne peut pas être négative");
		}
		Retiaire.cForce = cForce;
	}

	private static String getCType() {
		return Retiaire.cType;
	}

	private static void setCType(String cType) throws Exception {
		if(cType.isEmpty() || cType == null) {
			throw new ExceptionRetiaire("Le type d'un Retiaire ne peut pas être vide");
		}
		Retiaire.cType = cType;
	}


	private void setAgilite(int agilite) throws Exception {
		if(agilite < 0) {
			throw new ExceptionRetiaire("L'agilite d'un Retiare ne peut pas être négative");
		}
		this.agilite = agilite;
	}

	@Override
	public ArrayList<Gladiateur> getMesAggresseurs() {
		return null;
	}

}
