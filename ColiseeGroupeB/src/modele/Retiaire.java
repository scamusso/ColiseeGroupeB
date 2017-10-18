package modele;

import java.util.ArrayList;

/**
 * Retiaire est la classe représentante un gladiateur de type retiaire dans le colysée.
 * 
 * @author Stephane CAMUSSO
 * 
 */

public class Retiaire extends Gladiateur  {

	private static int cForce;
	private static String cType;
	private int agilite;
	private ArrayList<Gladiateur> agresseurs;
	
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
		Retiaire.cForce = 30;
		this.agilite = agilite;
		Retiaire.cType = "Retiaire";
		this.agresseurs = new ArrayList<Gladiateur>();
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
		if (agresseur != this){
			int defArme = 0;
			for (Arme object: getMesArmes()) {
			    defArme = defArme + object.getPuissanceDefensive();
			}
			if ((forceCoup - defArme  - this.agilite)>0){
				this.setVie(this.getVie() - (forceCoup - defArme - this.agilite));
				if (this.getVie()<0){
					this.setVie(0);
				}
			}
			
		}
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
	
	public ArrayList<modele.Gladiateur> getMesAggresseurs() {
		return agresseurs;
	}
	
	//Setters
	
	public void setCType() {
		Retiaire.cType = "Retiaire";
	}
	



}
