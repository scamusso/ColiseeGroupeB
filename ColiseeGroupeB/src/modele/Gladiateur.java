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
	private int id;
	private String nom;
	private int vie;
	private ArrayList<Arme> armes;

	
	/**
	 * Constructeur
	 * 
	 * @param idGladiateur
	 * @param nomGladiateur
	 * 
	 * 
	 */
	public Gladiateur(int idGladiateur, String nomGladiateur) {
		this.id = idGladiateur;
		this.vie = cVieInitiale;
		this.nom = nomGladiateur;
		this.armes = new ArrayList<Arme>();
		
	}


	/**
	 * 
	 * Permet d'afficher les armes du gladiateur
	 * 
	 * @return
	 */
	public String declarerMesArmes() {
		String declarationArme = "";
		System.out.println("Je possede les armes suivantes : ");
		for (Arme object: armes) {
		    declarationArme = declarationArme + object.description();
		}
		return declarationArme;
	}
	
	/**
	 * 
	 * Permet de savoir si le gladiateur est bien portant (c'est a dire que sa vie est a son maximum)
	 * 
	 * @return
	 */
	public boolean estBienPortant() {
		if (cVieInitiale == this.vie){
			return true;
		} else {
			return false;
		}		
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
		
		rapport = id + " " + nom + " "+ etatGladiateur + " " + vie + " " + getForce() + " " + declarerMesArmes();
		return rapport; 
	}	
	
	/**
	 * Permet d'ajouter une arme a la collection du gladiateur
	 * 
	 * @param arme
	 */
	public void recevoirArme(Arme arme) {
        boolean flagArme = false;
        for (Arme object: armes) {
            if (object.getNomArme() == arme.getNomArme()) {
                flagArme = true;
            }
        }
        if (flagArme==false){
            armes.add(arme);
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
		if (agresseur != this){
			int defArme = 0;
			for (Arme object: armes) {
			    defArme = defArme + object.puissanceDefensive;
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
	
	public static int getcVieInitiale() {
		return cVieInitiale;
	}
	
	public abstract int getForce();
	
	public int getIdGladiateur() {
		return id;
	}
	
	public abstract ArrayList<Gladiateur> getMesAggresseurs();
	
	public ArrayList<Arme> getMesArmes() {
		return armes;
	}
	
	public String getNom() {
		return nom;
	}
	
	public abstract String getType();

	public int getVie() {
		return vie;
	}
	
	//Setters
	
	public static void setcVieInitiale(int cVieInitiale) {
		Gladiateur.cVieInitiale = cVieInitiale;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
	
	public void setMesArmes(ArrayList<Arme> armes) {
		this.armes = armes;
	}
	

}
