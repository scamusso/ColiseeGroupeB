package modele;

import java.util.ArrayList;

import modele.Exception.ExceptionMirmillon;

/**
 * Mirmillon est la classe représentante un gladiateur de type mirmillon dans le colysée.
 * 
 * @author Stephane CAMUSSO
 * @version 2.0
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
	 * @param idGladiateur Id du gladiateur a creer
	 * @param nomGladiateur nom du gladiateur a creer
	 * @param poids Poids du gladiateur a creer
	 * @throws Exception 
	 */
	public Mirmillon(int idGladiateur, String nomGladiateur, int poids) throws Exception {
		super(idGladiateur, nomGladiateur);
		this.setPoids(poids);
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
		ArrayList<Gladiateur> mesAgresseurs = getMesAggresseurs();
		String listeAgresseur = "";
		for(Gladiateur agresseur:mesAgresseurs){
			listeAgresseur += agresseur.getNom()+" ";
		}
		return super.rapport() + " "+listeAgresseur;
	}	
	
	/**
	 * 
	 * Permet de descendre la vie du gladiateur en fonction de la force du coup recu
	 * On enregistre aussi l'agresseur pour pouvoir restituer la liste en cas de besoin
	 * Pour le Mirmillon, on enregistre l'agresseur
	 * 
	 * @param agresseur Gladiateur qui donne le coup
	 * @param forceCoup Force du coup qui est donnee
	 */
	public void recevoirCoup(Gladiateur agresseur, int forceCoup) throws Exception{
		super.recevoirCoup(agresseur, forceCoup);
		this.addAgresseurs(agresseur);
	}
	
	private void addAgresseurs(Gladiateur pAgresseur) throws Exception {
		if(pAgresseur == null) {
			throw new ExceptionMirmillon("Retiaire ne peut avoir d'agresseur NULL");
		}
		this.mesAgresseurs.add(pAgresseur);
	}
	//Getters

	public int getPoids() {
		return this.poids;
	}

	public int getForce() {
		return this.poids/2;
	}

	public ArrayList<Gladiateur> getMesAggresseurs() {
		return this.mesAgresseurs;
	}
	
	public String getType() {
		return Mirmillon.cType;
	}

	//Setters
	
	public static void setCType(String cType) throws Exception {
		if(cType.isEmpty() || cType == null) {
			throw new ExceptionMirmillon("Le type du mirmillon ne peut pas être vide");
		}
		Mirmillon.cType = cType;
	}

	public void setMesAgresseurs(ArrayList<modele.Gladiateur> mesAgresseurs) throws Exception {
		if(mesAgresseurs == null) {
			throw new ExceptionMirmillon("La liste des agresseur du Mirmillon ne peut être NULL");
		}
		this.mesAgresseurs = mesAgresseurs;
	}


	private void setPoids(int poids) throws Exception {
		if(poids < 0) {
			throw new ExceptionMirmillon("Le poid d'un Mirmillon ne peut être inférieur ou égal à 0");
		}
		this.poids = poids;
	}

}
