package controlleur;
import java.util.ArrayList;
import modele.Arme;

/**
 * GArme est la classe du gestionnaire d'arme
 * contient l'id de la prochaine arme a creer
 * et la liste de toutes les armes creees
 * 
 * @author Aline
 *
 */
public class GArme {
	
	/**
	 * Id de la prochaine arme
	 * s'incremente a la creation d'une arme
	 */
	private static int nextIdArme = 1;
	/**
	 * Liste des armes creees
	 */
	private ArrayList<Arme> toutesLesArmes;
	
	public GArme() {
		this.toutesLesArmes= new ArrayList<Arme>();
	}

	/**
	 * Ajouter une nouvelle arme
	 * @param nomArme
	 * @param puissOff
	 * @param puissDef
	 * @return arme
	 */
	public Arme ajouterArme(String nomArme, int puissOff, int puissDef) {
		this.toutesLesArmes.add(new Arme(nextIdArme++, nomArme, puissOff, puissDef));		
		return this.toutesLesArmes.get(this.toutesLesArmes.size()-1);
	}
	
	/**
	 * Recupere une arme par son id dans la liste des armes creees
	 * @param idArme
	 * @return
	 */
	public Arme getArme(int idArme){
		for(Arme arme : this.toutesLesArmes) {
			if(arme.getIdArme() == idArme) {
				return arme;
			}	
		}
		return null;
	}

	/**
	 * Getter
	 */
	public ArrayList<Arme> getToutesLesArmes() {
		return this.toutesLesArmes;
	}
}
