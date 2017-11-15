package modele;

import modele.Exception.ExceptionArme;

/**
 * Arme est la classe repr√©sentant une arme.
 * Est caract√©ris√©e par :
 * un id d'arme
 * un nom d'arme
 * une puissance offensive
 * une puissance d√©fensive
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
	 * l'id, le nom, les puissances offensive et defensive sont donn√©es √† la construction de l'arme 
	 * @param idArme Id de l'arme a creer
	 * @param nomArme Nom de l'arme a creer
	 * @param puissOff Puissance offensive de l'arme a creer
	 * @param puissDef Puissance defensive de l'arme a creer
	 * @throws Exception Leve une exception si
	 * 				L'id de l'arme est inferieur ou egal ‡ 0
	 * 				Le nom de l'arme est vide
	 * 				La puissance offensive d'une arme est inferieur a 0
	 * 				La puissance defensive d'une arme est inferieur a†0
	 */
	public Arme(int idArme, String nomArme, int puissOff, int puissDef) throws Exception {
		this.setIdArme(idArme);
		this.setNomArme(nomArme);
		this.setPuissanceOffensive(puissOff);
		this.setPuissanceDefensive(puissDef);
	}
	
	/**
	 * Retourne la liste des caracteristique de l'arme
	 * @return String
	 */
	public String description(){
		
		return ("ID arme : " + this.getIdArme() + ", Nom de l'arme : " + this.getNomArme() + ", Puissance offensive : " + this.getPuissanceOffensive() + ", Puissance d√©fensive : " + this.getPuissanceDefensive() + ". ").toString();	
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
	 * @param puissanceOffensive La valeur de la puissance offensive a appliquer au gladiateur
	 * @throws Exception Leve une exception si la puissance offensive est inferieur ‡ 0
	 */
	public void setPuissanceOffensive(int puissanceOffensive) throws Exception {
		if(puissanceOffensive<0){
			throw new ExceptionArme("La puissance offensive d'une arme ne peut etre inferieur a 0");
		}
		this.puissanceOffensive = puissanceOffensive;
	}
	/**
	 * Met a jour la puissance defensive de l'arme
	 * @param puissanceDefensive La valeur de la puissance defensive a appliquer au gladiateur
	 * @throws Exception Leve une exception si le puissance defensive est inferieur a 0
	 */
	public void setPuissanceDefensive(int puissanceDefensive) throws Exception {
		if(puissanceDefensive<0){
			throw new ExceptionArme("La puissance defensive d'une arme ne peut pas etre inferieur ‡ 0");
		}
		this.puissanceDefensive = puissanceDefensive;
	}
    
	private void setNomArme(String nomArme) throws Exception {
		if(nomArme.isEmpty() && nomArme == null) {
			throw new ExceptionArme("Le nom de l'arme de ne peut pas etre vide");
		}
		this.nomArme = nomArme;
	}

    private void setIdArme(int idArme) throws Exception {
		if(idArme <= 0) {
			throw new ExceptionArme("L'id de l'arme de ne peut pas etre inferieur ou egal a 0");
		}
        this.idArme = idArme;
    }
}
