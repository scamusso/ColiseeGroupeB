package controlleur;

import java.util.ArrayList;
import java.util.Random;

import modele.Arme;
import modele.Gladiateur;
import java.util.concurrent.ThreadLocalRandom;

public class CColiseeConsole {
	
	// Variable de classe
	private static GGladiateur gGladiateur;
	private static GArme gArme;
	private static Random randomGenerator;

	/**
	 * Constructeur
	 */
	public CColiseeConsole() {
		gGladiateur = new GGladiateur();
		gArme=new GArme();
		randomGenerator = new Random();
	}
	/**
	 * Chargement du jeu d'essai
	 */
	public static void chargerJeuDEssai(){
		//Récuperer fichier XML
		
		//Pour Chaque infos du fichier, Créer Gladiateurs et Armes
		
		
		// Generation de quelques gladiateurs pour test
		try {
			Facade.creerRetiaire("Unix", 30);
		
			Facade.creerMirmillon("Infomatix", 100);
			Facade.creerRetiaire("Ceplusplus", 40);
			Facade.creerMirmillon("Pythonus", 60);
			Facade.creerRetiaire("Szervlet", 50);
			Facade.creerMirmillon("Ramazmjet", 80);
			//Créer les armes
			Facade.creerUneArme("Glaive", 80, 0);
			Facade.creerUneArme("trident", 100, 0);
			Facade.creerUneArme("Filet", 40, 20);
			Facade.creerUneArme("Bouclier", 40, 40);
			Facade.creerUneArme("Casque", 0, 20);
			Facade.creerUneArme("Jambière", 0, 10);
			Facade.donnerUneArme(1, 2);
			Facade.donnerUneArme(1, 6);
			Facade.donnerUneArme(1, 3);
			Facade.donnerUneArme(2, 1);
			Facade.donnerUneArme(2, 4);
			Facade.donnerUneArme(2, 5);
			Facade.donnerUneArme(2, 6);	
			Facade.donnerUneArme(3, 2);
			Facade.donnerUneArme(3, 6);
			Facade.donnerUneArme(4, 1);
			Facade.donnerUneArme(4, 4);
			Facade.donnerUneArme(5, 1);
			Facade.donnerUneArme(5, 6);
			Facade.donnerUneArme(6, 4);
			Facade.donnerUneArme(6, 5);
		} catch (Exception e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
	}
	
	/**
	 * Lancement du combat automatique 
	 * @throws Exception 
	 */
	public static void lancerCombat() throws Exception{
		
		//Avant le combat Pour chaque gladiateur
		System.out.println("Bienvenu dans le jeu des gladiateur");
		ArrayList<Gladiateur> touslesgladiateurs = Facade.listerTousLesGladiateurs();
		ArrayList<Integer> touslesidgladiateurs=new ArrayList<Integer>();
		
		for(Gladiateur gladiateur : touslesgladiateurs){
			
			//Avant combat : Salut des gladiateurs (id, nom, type)
			System.out.println(gladiateur.saluer());
			touslesidgladiateurs.add(gladiateur.getIdGladiateur());
		}
		// Tant qu'il y a plus qu'un gladiateurs encore en vie, les combats continuent
		while(touslesgladiateurs.size()>1){
			
			ArrayList<Integer> idgladiateursmoribond=new ArrayList<Integer>();
			//reset liste des id gladiateurs mort au combat precedent
			idgladiateursmoribond.clear();
			
			//Boucle Combat
			for(Gladiateur gladiateur : touslesgladiateurs){
				
				if(!gladiateur.estMoribond()){
					
					//Choisit aléatoirement un autre gladiateur comme cible
					
					int pIdAgresseur = gladiateur.getIdGladiateur();
					int pIdVictime = pIdAgresseur;
					
					while(pIdVictime==pIdAgresseur){
						int index = randomGenerator.nextInt(touslesidgladiateurs.size());
						pIdVictime = touslesidgladiateurs.get(index);
					}
					
					//Choisit aléatoirement une arme offensive parmis ses armes
					ArrayList<Arme> touteslesarmesdugladiateur = Facade.declarerArmes(pIdAgresseur);
					
					int index = randomGenerator.nextInt(touteslesarmesdugladiateur.size());
					int pIdArme = touteslesarmesdugladiateur.get(index).getIdArme();
					
					
					// Message avec Gladiateur agresseur, Gladiateur cible, Arme, Puissance coup
					System.out.println("Rapport gladiateur agresseur");
					System.out.println(gladiateur.rapport());
					
					//Frappe sa cible
					Facade.frapper(pIdAgresseur, pIdVictime, pIdArme);
					
					// Message avec Gladiateur cible, Gladiateur agresseur, et degats encaissés
					System.out.println("Rapport gladiateur victime");
					System.out.println(Facade.faireRapport(pIdVictime));
					
					// Si le gladiateur victime meurt apres etre frapper, stock son id dans le tableau des gladiateurs mort dans cette manche
					if(GGladiateur.getGladiateur(pIdVictime).estMoribond()){
						System.out.println("gladiateur victime est mort");
						idgladiateursmoribond.add(pIdVictime);
					}
				}
			}
			//Si le gladiateur attaqué est mort, supprime de la liste des gladiateurs vivants
			if(idgladiateursmoribond.size()>0){
				
				for(int i=0;i<idgladiateursmoribond.size();i++){
					for(int j=0;j<touslesgladiateurs.size();j++){
				        if(touslesgladiateurs.get(j).getIdGladiateur() == idgladiateursmoribond.get(i)){
				        	touslesgladiateurs.remove(j);
				        	break;
				        	
				        }
				        
					}
					for(int j=0;j<touslesidgladiateurs.size();j++){
						if(touslesidgladiateurs.get(j) == idgladiateursmoribond.get(i)){
							touslesidgladiateurs.remove(j);
						}
					}
				}
			}
		}
		//Fin du combat : annonce détail vainqueur (rapport v1)
		System.out.println("Gladiateur gagnant : ");
		touslesgladiateurs.get(0).rapport();
	}
	
}
