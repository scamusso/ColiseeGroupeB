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

	private Gladiateur dernierMort;



	/**
	 * constructeur d'un objet CombatGladiateur
	 * @param groupe de processus contenant les processus de combats
	 * @param gladiateur qui va combattre
	 */
	public CombatGladiateur(ThreadGroup groupe, Gladiateur gladiateur){
		super(groupe, "Combat du gladiateur Id : "+gladiateur.getIdGladiateur());
		this.gladiateur = gladiateur;
	}


	/**
	 * Effectue le combat d'un gladiateur
	 * @param gladiateur de type Gladiateur, le gladiateur qui doit combattre
	 * @return le gladiateur gagnant
	 */
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

				//System.out.print(GGladiateur.getGladiateur(pIdAgresseur));
				if(GGladiateur.getGladiateur(pIdAgresseur) != null){


					//Choisit aleatoirement une arme offensive parmis ses armes
					int puissOffArme =0;
					int pIdArme = 0;
					ArrayList<Arme> touteslesarmesdugladiateur = CColiseeConsole.declarerArmes(pIdAgresseur);
					//System.out.print(touteslesarmesdugladiateur);
					//System.out.println("taille du tableau arme "+ touteslesarmesdugladiateur.size());
					if(touteslesarmesdugladiateur.size() > 0){
						
						while(puissOffArme==0){
							int index = randomGenerator.nextInt(touteslesarmesdugladiateur.size());
							pIdArme = touteslesarmesdugladiateur.get(index).getIdArme();
							puissOffArme = touteslesarmesdugladiateur.get(index).getPuissanceOffensive();
						}


						//Frappe sa cible

						try {
							CColiseeConsole.frapper(pIdAgresseur, pIdVictime, pIdArme);
						} catch (Exception e) {
							System.out.println("Frappe un gladiateur mort \n");
						}



						// Si le gladiateur victime meurt apres etre frapper, le supprime de la liste des gladiateurs encore en combat

						if(GGladiateur.getGladiateur(pIdVictime) != null && GGladiateur.getGladiateur(pIdVictime).estMoribond()){
							dernierMort = GGladiateur.getGladiateur(pIdVictime);
							tousLesGladiateurs.remove(GGladiateur.getGladiateur(pIdVictime));
						}
					}
				}

			}
			else{
				return null;
			}

		}
		// Retourne le dernier gladiateur en vie
		if(tousLesGladiateurs.size()>0){
			return tousLesGladiateurs.get(0);
		}else{
			return getDernierMort();
		}


	}

	/**
	 * Retourne le gladiateur gagnant
	 * @return gladiateur
	 */
	public Gladiateur getGagnant(){
		return gagnant;
	}

	public Gladiateur getDernierMort(){
		return dernierMort;
	}


	/**
	 * méthode principal du nouveau thread
	 */
	public void run(){
		randomGenerator = new Random();

		if(combattre(gladiateur) != null){
			gagnant = combattre(gladiateur);
		}
	}
}
