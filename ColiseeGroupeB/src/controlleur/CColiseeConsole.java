package controlleur;

import java.util.ArrayList;
import java.util.Random;

import modele.CombatGladiateur;
import modele.Gladiateur;
import modele.ReadXMLFile;


public class CColiseeConsole extends Facade{
	
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
	public static void chargerJeuDEssai(String filepath){
		
		//Pour Chaque infos du fichier, Créer Gladiateurs et Armes
		try {
			new ReadXMLFile(filepath);
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
		System.out.println("\n Bienvenu dans le jeu des gladiateurs ! \n" );
		ArrayList<Gladiateur> touslesgladiateurs = Facade.listerTousLesGladiateurs();
		ArrayList<Integer> touslesidgladiateurs=new ArrayList<Integer>();
		
		//cr�er les objets de combats
		ThreadGroup groupeDeCombat = new ThreadGroup("Groupe de combat des gladiateurs");	
  		ArrayList<CombatGladiateur> combats = new ArrayList<CombatGladiateur>();
  		
		for(Gladiateur gladiateur : touslesgladiateurs){
			
			//Avant combat : Salut des gladiateurs (id, nom, type)
			System.out.println(gladiateur.saluer());
	  		combats.add(new CombatGladiateur(groupeDeCombat, gladiateur));
			
		}
		
		System.out.println("\n");
		
		//lancer les recherches
		for(CombatGladiateur combat:combats){
			combat.start();
		}
		  
		//attendre que les processus de mon groupe soit tous termin�s
		while (groupeDeCombat.activeCount() >0 ){
			Thread.sleep(100);
		}
		
		for(CombatGladiateur combat:combats){
			 Gladiateur gagnant = combat.getGagnant();
			 if(gagnant !=null){
				System.out.println("Gladiateur gagnant : ");
				System.out.println(gagnant.rapport());
				System.exit (0);
				return;
			 }
		  }
	}
	
	/**
	 * Methode qui permet de lancer l'action frapper
	 * @param pIdAgresseur : int
	 * @param pIdVictime : int
	 * @param pIdArme: int
	 * @throws Exception 
	 */
	public static void frapper(int pIdAgresseur, int pIdVictime, int pIdArme) throws Exception {
		if(!gGladiateur.getGladiateur(pIdAgresseur).estMoribond() && ! gGladiateur.getGladiateur(pIdVictime).estMoribond()) {
			System.out.println(gGladiateur.getGladiateur(pIdAgresseur).messageAgresseur(gGladiateur.getGladiateur(pIdVictime), gArme.getArme(pIdArme))+"\n");
			gGladiateur.getGladiateur(pIdAgresseur).frapper(gGladiateur.getGladiateur(pIdVictime), gArme.getArme(pIdArme));
			System.out.println(gGladiateur.getGladiateur(pIdVictime).messageVictime(gGladiateur.getGladiateur(pIdAgresseur), gArme.getArme(pIdArme))+"\n");
		}
	}
}
