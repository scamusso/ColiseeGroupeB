package modele;

import java.util.ArrayList;


/**
 * Gladiateur est la classe représentante un gladiateur dans le colysée.
 * 
 * @author Stephane CAMUSSO
 * 
 */

public abstract class Gladiateur {

	private static int cVieInitiale = 200;
	private int idGladiateur ;
	private String nom;
	private int vie = cVieInitiale;
	private ArrayList<Arme> mesArmes;


	/**
	 * Constructeur
	 * 
	 * @param idGladiateur
	 * @param nomGladiateur
	 * 
	 * 
	 */
	public Gladiateur(int idGladiateur, String nomGladiateur) {
		this.idGladiateur  = idGladiateur;
		this.nom = nomGladiateur;
		this.mesArmes = new ArrayList<Arme>();
	}


	/**
	 * 
	 * Permet d'afficher les armes du gladiateur
	 * 
	 * @return
	 */
	public String[] declarerMesArmes() {
		String tableauArmes[] = new String[mesArmes.size()];
		int compteur = 0;
		String rapport = "";
		for (Arme object: mesArmes) {
			tableauArmes[compteur] = object.description();
			rapport += tableauArmes[compteur];
			compteur++;	
		}
		System.out.println("Voila mes armes : " + rapport);
		return tableauArmes;
	}

	/**
	 * 
	 * Permet de savoir si le gladiateur est bien portant (c'est a dire que sa vie est a son maximum)
	 * 
	 * @return
	 */
	public boolean estBienPortant() {
		return (cVieInitiale == this.vie);	
	}


	/**
	 * Permet de savoir si le gladiateur est blessé, c'est a dire vivant mais pas bien portant
	 * 
	 * @return
	 */
	public boolean estBlesse() {
		if (this.vie < cVieInitiale && this.vie!=0){
			return true;
		} else {
			return false;
		}		
	}

	/**
	 * 
	 * Permet de savoir si le gladiateur est mort
	 * 
	 * @return
	 */
	public boolean estMoribond() {
		if (this.vie==0){
			return true;
		} else {
			return false;
		}	
	}

	/**
	 * 
	 * Permet au gladiateur d'en frapper un autre avec une arme
	 * 
	 * @param gladiateur
	 * @param arme
	 */
	public void frapper(Gladiateur gladiateur, Arme arme) {
		gladiateur.recevoirCoup(this, arme.getPuissanceOffensive() + this.getForce());
	}

	/**
	 * 
	 * Permet au gladiateur de faire un rapport sur lui meme
	 * 
	 * @return rapport
	 */
	public String rapport() {
		String etatGladiateur;
		String rapport = "";

		if (estBienPortant()) {
			etatGladiateur = "Bien portant";
		} else if (estBlesse()) {
			etatGladiateur = "Blessé";
		} else {
			etatGladiateur = "Moribond";
		}

		rapport = idGladiateur  + " " + nom + " "+ etatGladiateur + " " + vie + " " + getForce() + " " + declarerMesArmes();
		return rapport; 
	}	

	/**
	 * Permet d'ajouter une arme a la collection du gladiateur
	 * 
	 * @param arme
	 */
	public void recevoirArme(Arme arme) {
		boolean flagArme = false;
		for (Arme object: mesArmes) {
			if (object.getIdArme() == arme.getIdArme()) {
				flagArme = true;
			}
		}
		if (flagArme==false){
			mesArmes.add(arme);
		}

	}

	/**
	 * 
	 * Permet de descendre la vie du gladiateur en fonction de la force du coup recu
	 * On enregistre aussi l'agresseur pour pouvoir restituer la liste en cas de besoin
	 * 
	 * @param agresseur
	 * @param forceCoup
	 */
	public void recevoirCoup(Gladiateur agresseur, int forceCoup) {
		if (agresseur != this && (!estBienPortant() && !estBlesse())){
			int defArme = 0;
			for (Arme object: mesArmes) {
				defArme = defArme + object.getPuissanceDefensive();
			}
			if ((forceCoup - defArme)>0){
				this.vie = vie - (forceCoup - defArme);
				if (this.vie<0){
					this.vie = 0;
				}
			}
		}
	}

	/**
	 * Permet au gladiateur de saluer / se presenter
	 * 
	 * @return
	 */
	public String saluer() {
		String salutation = "Ave Caesar, " + getType() + " N°" + getIdGladiateur() + " : " + getNom();
		return salutation;
	}



	//Getters

	public static int getCVieInitiale() {
		return cVieInitiale;
	}

	public abstract int getForce();

	public int getIdGladiateur() {
		return idGladiateur ;
	}

	public abstract ArrayList<Gladiateur> getMesAggresseurs();

	public ArrayList<Arme> getMesArmes() {
		return mesArmes;
	}

	public String getNom() {
		return nom;
	}

	public abstract String getType();

	public int getVie() {
		return vie;
	}

	//Setters

	public static void setCVieInitiale(int cVieInitiale) {
		Gladiateur.cVieInitiale = cVieInitiale;
	}

	public void setVie(int vie) {
		if (!estBienPortant() && !estBlesse()) {
			this.vie = vie;
		}
	}

	public void setMesArmes(ArrayList<Arme> armes) {
		this.mesArmes = armes;
	}


}
