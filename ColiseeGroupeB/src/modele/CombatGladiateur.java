package modele;

import java.util.ArrayList;
import java.util.Random;

import controlleur.CColiseeConsole;
import controlleur.GGladiateur;

/**
 * Classe de gestion des combats des gladiateurs
 * 
 */
public class CombatGladiateur extends Thread {
	
	private static ArrayList<Gladiateur> tousLesGladiateurs = CColiseeConsole.listerTousLesGladiateurs();
	private static Random randomGenerator;
	//Gladiateur qui effectue le combat
	private Gladiateur gladiateur;
	//Gladiateur gagnant
	private Gladiateur gagnant;
	
	
	
	/**
	 * constructeur d'un objet CombatGladiateur
	 * @param groupe de processus contenant les processus de recherche
	 * @param cheminFichier chemin veres le fichier contenant la base d'utilisateurs à utiliser
	 * @param identifiant identifiant à chercher
	 */
	public CombatGladiateur(ThreadGroup groupe, Gladiateur gladiateur){
		super(groupe, "Combat du gladiateur Id : "+gladiateur.getIdGladiateur());
		this.gladiateur = gladiateur;
	}
	
	
	
	public Gladiateur combattre(Gladiateur gladiateur) /*throws Exception*/{
		
		while(tousLesGladiateurs.size()>1){
		
			if(!gladiateur.estMoribond()){
				
				//Choisit aleatoirement un autre gladiateur comme cible
				
				int pIdAgresseur = gladiateur.getIdGladiateur();
				int pIdVictime = pIdAgresseur;
				
				
				while(pIdVictime==pIdAgresseur){
					int index = randomGenerator.nextInt(tousLesGladiateurs.size());
					pIdVictime = tousLesGladiateurs.get(index).getIdGladiateur();
				}
				
				
				
				//Choisit aleatoirement une arme offensive parmis ses armes
				
				ArrayList<Arme> touteslesarmesdugladiateur = CColiseeConsole.declarerArmes(pIdAgresseur);
				
				int index = randomGenerator.nextInt(touteslesarmesdugladiateur.size());
				int pIdArme = touteslesarmesdugladiateur.get(index).getIdArme();
				
				
				
				//Frappe sa cible
				
				try {
					CColiseeConsole.frapper(pIdAgresseur, pIdVictime, pIdArme);
				} catch (Exception e) {
					System.out.println("Frappe un gladiateur mort \n");
				}
				
				
				
				// Si le gladiateur victime meurt apres etre frapper, le supprime de la liste des gladiateurs encore en combat
				
				if(GGladiateur.getGladiateur(pIdVictime) != null && GGladiateur.getGladiateur(pIdVictime).estMoribond()){
					tousLesGladiateurs.remove(GGladiateur.getGladiateur(pIdVictime));
				}
				
			}
			else{
				return null;
			}
			
		}
		// Retourne le dernier gladiateur en vie
		return tousLesGladiateurs.get(0);
		
	}
	
	/**
	 * Retourne le gladiateur gagnant
	 * @return gladiateur
	 */
	public Gladiateur getGagnant(){
		return gagnant;
	}
	
	
	/**
	 * méthode principal du nouveau thread
	 */
	public void run(){
		randomGenerator = new Random();
		//System.out.println("debut combat pour glad : "+gladiateur.getIdGladiateur() +"\n");
		
		if(combattre(gladiateur) != null){
			gagnant = combattre(gladiateur);
		}
	}
}
