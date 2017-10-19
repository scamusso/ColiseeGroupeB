package modele;

import java.util.ArrayList;

import modele.Exception.ExceptionGladiateur;


/**
 * Gladiateur est la classe représentante un gladiateur dans le colysée.
 * 
 * @author Stephane CAMUSSO
 * @version 2.0
 * MAJ le 19/10/2017
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
	 * @throws Exception 
	 * 
	 * 
	 */
	public Gladiateur(int idGladiateur, String nomGladiateur) throws Exception {
		this.setIdGladiateur(idGladiateur);
		this.setNom(nomGladiateur);
		this.setMesArmes(new ArrayList<Arme>());
	}


	/**
	 * 
	 * Permet d'afficher les armes du gladiateur
	 * 
	 * @return tableauArmes String[]
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
		return tableauArmes;
	}

	/**
	 * 
	 * Permet de savoir si le gladiateur est bien portant (c'est a dire que sa vie est a son maximum)
	 * 
	 * @return boolean
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
		return (this.getVie() < cVieInitiale && this.getVie()!=0);
	}

	/**
	 * 
	 * Permet de savoir si le gladiateur est mort
	 * 
	 * @return
	 */
	public boolean estMoribond() {
		return (this.getVie() == 0);
	}

	/**
	 * 
	 * Permet au gladiateur d'en frapper un autre avec une arme
	 * 
	 * @param gladiateur
	 * @param arme
	 * @throws Exception 
	 */
	public void frapper(Gladiateur gladiateur, Arme arme) throws Exception {
		gladiateur.recevoirCoup(this, arme.getPuissanceOffensive() + this.getForce());
	}

	/**
	 * 
	 * Permet au gladiateur de faire un rapport sur lui meme
	 * 
	 * @return rapport String
	 */
	public String rapport() {
		String etatGladiateur;

		if (estBienPortant()) {
			etatGladiateur = "Bien portant";
		} else if (estBlesse()) {
			etatGladiateur = "Blessé";
		} else {
			etatGladiateur = "Moribond";
		}

		return idGladiateur  + " " + nom + " "+ etatGladiateur + " " + vie + " " + this.getForce() + " " + String.join(" ",declarerMesArmes());
	}	

	/**
	 * Permet d'ajouter une arme a la collection du gladiateur
	 * 
	 * @param arme
	 */
	public void recevoirArme(Arme arme) throws Exception {
		if(arme == null) {
			throw new ExceptionGladiateur("Un gladiateur ne peut recevoir une arme null");
		}
		for (Arme object: mesArmes) {
			if (object.getIdArme() == arme.getIdArme()) {
				return;
			}
		}
			mesArmes.add(arme);
	}

	/**
	 * 
	 * Permet de descendre la vie du gladiateur en fonction de la force du coup recu
	 * On enregistre aussi l'agresseur pour pouvoir restituer la liste en cas de besoin
	 * 
	 * @param agresseur
	 * @param forceCoup
	 */
	public void recevoirCoup(Gladiateur agresseur, int forceCoup) throws Exception{
		if(agresseur == null || forceCoup < 0) {
			throw new ExceptionGladiateur("Un Gladiateur ne peut recevoir un coup avec une Force négative ou recevoir un coup d'un Gladiateur inexistant");
		}
		if (agresseur != this && (!estBienPortant() && !estBlesse())){
			int defArme = 0;
			for (Arme object: mesArmes) {
				defArme += object.getPuissanceDefensive();
			}
			if ((forceCoup - defArme)>0){
				if (this.getVie() - (forceCoup - defArme) <0){
					this.setVie(0);
				}
			}
		}
	}

	/**
	 * Permet au gladiateur de saluer / se presenter
	 * 
	 * @return salutation
	 */
	public String saluer() {
		return "Ave Caesar, " + this.getType() + " N°" + this.getIdGladiateur() + " : " + this.getNom();
	}



	//Getters

	public static int getCVieInitiale() {
		return Gladiateur.cVieInitiale;
	}

	public abstract int getForce();

	public int getIdGladiateur() {
		return this.idGladiateur ;
	}

	public abstract ArrayList<Gladiateur> getMesAggresseurs();

	public ArrayList<Arme> getMesArmes() {
		return this.mesArmes;
	}

	public String getNom() {
		return this.nom;
	}

	public abstract String getType();

	public int getVie() {
		return this.vie;
	}

	//Setters

	public static void setCVieInitiale(int cVieInitiale) throws Exception {
		if(cVieInitiale <= 0) {
			throw new ExceptionGladiateur("La vie initial d'un Gladiateur ne peut inférieur ou égal à 0");
		}
		Gladiateur.cVieInitiale = cVieInitiale;
	}

	public void setVie(int vie) throws Exception {
		if(vie < 0) {
			throw new ExceptionGladiateur("La vie d'un gladiateur ne peut pas être inférieur à 0");
		}
		this.setVie(vie);
	}

	public void setMesArmes(ArrayList<Arme> armes) throws Exception {
		if(armes == null) {
			throw new ExceptionGladiateur("Unexpected Weapon's");
		}
		this.mesArmes = armes;
	}
	
	private void setIdGladiateur(int idGladiateur) throws Exception {
		if(idGladiateur < 0) {
			throw new ExceptionGladiateur("L'id d'un Gladiateur ne peut pas être négatif");
		}
		this.idGladiateur = idGladiateur;
	}


	private void setNom(String nom) throws Exception {
		if(nom.isEmpty() || nom == null) {
			throw new ExceptionGladiateur("Le nom d'un gladiateur ne peut être vide");
		}
		this.nom = nom;
	}


}
