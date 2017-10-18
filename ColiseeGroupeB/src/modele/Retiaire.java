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
		this.setAgilite(agilite);
		this.setAgresseurs(new ArrayList<Gladiateur>()); 
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
	
	private void setCType() {
		Retiaire.cType = "Retiaire";
	}
	
	private static int getcForce() {
		return cForce;
	}

	private static void setcForce(int cForce) {
		Retiaire.cForce = cForce;
	}

	private static String getcType() {
		return cType;
	}

	private static void setcType(String cType) {
		Retiaire.cType = cType;
	}

	private ArrayList<Gladiateur> getAgresseurs() {
		return agresseurs;
	}

	private void setAgresseurs(ArrayList<Gladiateur> agresseurs) {
		this.agresseurs = agresseurs;
	}

	private void setAgilite(int agilite) {
		this.agilite = agilite;
	}

	



}
