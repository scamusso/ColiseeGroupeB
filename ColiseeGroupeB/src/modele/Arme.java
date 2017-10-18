package modele;
/**
 * Arme est la classe représentant une arme.
 * Est caractérisée par :
 * un id d'arme
 * un nom d'arme
 * une puissance offensive
 * une puissance défensive
 * 
 * @author Aline
 *
 */
public class Arme {
	/**
	 * Id de l'arme
	 * n'est pas modifiable
	 */
	private int idArme;
	
	/**
	 * Nom de l'arme
	 * n'est pas modifiable
	 */
	private String nomArme;
	
	/**
	 * puissance defensive de l'arme
	 * est modifiable
	 */
	private int puissanceDefensive;
	
	/**
	 * puissance offensive de l'arme
	 * est modifiable
	 */
	
	private int puissanceOffensive;

	/**
	 * Constructeur Arme
	 * l'id, le nom, les puissances offensive et defensive sont données à la construction de l'arme 
	 * @param idArme
	 * @param nomArme
	 * @param puissOff
	 * @param puissDef
	 */
	public Arme(int idArme, String nomArme, int puissOff, int puissDef){
		this.idArme = idArme;
		this.nomArme = nomArme;
		this.puissanceOffensive = puissOff;
		this.puissanceDefensive = puissDef;
	}
	
	/**
	 * Retourne la liste des caracteristique de l'arme
	 * @return String
	 */
	public String description(){
		
		return "ID arme : " + this.idArme + ", Nom de l'arme : " + this.nomArme + ", Puissance offensive : " + this.puissanceOffensive + ", Puissance défensive : " + this.puissanceDefensive + ". ";
		
	}
	/**
	 * Retourne le nom de l'arme
	 * @return String
	 */
	public String getNomArme() {
		return this.nomArme;
	}
	
	/**
	 * Retourne la puissance offensive de l'arme
	 * @return int
	 */
	public int getPuissanceOffensive() {
		return this.puissanceOffensive;
	}
	
	/**
	 * Retourne l'id de l'arme
	 * @return int
	 */
	public int getIdArme() {
		return this.idArme;
	}
	
	/**
	 * Retourne la puissance defensive de l'arme
	 * @return int
	 */
	public int getPuissanceDefensive() {
		return this.puissanceDefensive;
	}
	
	/**
	 * Met a jour la puissance offensive de l'arme
	 * @param puissanceOffensive
	 */
	public void setPuissanceOffensive(int puissanceOffensive) {
		if(puissanceOffensive>0){
			this.puissanceOffensive = puissanceOffensive;
		} else {
			System.out.println("puissanceOffensive incorrecte");
		}
		
	}
	/**
	 * Met a jour la puissance defensive de l'arme
	 * @param puissanceDefensive
	 */
	public void setPuissanceDefensive(int puissanceDefensive) {
		if(puissanceDefensive>0){
			this.puissanceDefensive = puissanceDefensive;
		} else {
			System.out.println("puissanceDefensive incorrecte");
		}
	}

	

	

	

	
	
	

}
