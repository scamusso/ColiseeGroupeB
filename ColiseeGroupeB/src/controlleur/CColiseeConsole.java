package controlleur;

import java.util.ArrayList;
import java.util.Random;

import modele.Gladiateur;
import modele.ReadXMLFile;

/**
 * Herite de la classe Facade, Permet la gestion des combats automatisés
 * @author Aline
 *
 */
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
	 * @param filepath chemin du fichier xml a charger
	 */
	public static void chargerJeuDEssai(String filepath){
		
		//Pour Chaque infos du fichier, Creer Gladiateurs et Armes
		try {
			new ReadXMLFile(filepath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Lancement du combat automatique 
	 * @throws Exception Releve les erreurs
	 */
	public static void lancerCombat() throws Exception{
		
		//Avant le combat Pour chaque gladiateur
		System.out.println("\n Bienvenu dans le jeu des gladiateurs ! \n" );
		ArrayList<Gladiateur> touslesgladiateurs = Facade.listerTousLesGladiateurs();
		ArrayList<Integer> touslesidgladiateurs=new ArrayList<Integer>();
		
		//créer les objets de combats
		ThreadGroup groupeDeCombat = new ThreadGroup("Groupe de combat des gladiateurs");	
  		ArrayList<CombatGladiateur> combats = new ArrayList<CombatGladiateur>();
  		
		for(Gladiateur gladiateur : touslesgladiateurs){
			
			//Avant combat : Salut des gladiateurs (id, nom, type)
			System.out.println(gladiateur.saluer());
	  		combats.add(new CombatGladiateur(groupeDeCombat, gladiateur));
			
		}
		
		System.out.println("\n");
		
		//lancer les combats
		for(CombatGladiateur combat:combats){
			try{
				combat.start();
			}catch(Exception e){
				System.out.println("exception "+e);
			}
			
		}
		  
		//attendre que les processus de mon groupe soit tous terminés
		while (groupeDeCombat.activeCount() >0 ){
			Thread.sleep(100);
		}
		
		//Annonce le gladiateur gagnant
		for(CombatGladiateur combat:combats){
			 Gladiateur gagnant = combat.getGagnant();
			 if(gagnant !=null){
				System.out.println("Gladiateur gagnant : ");
				System.out.println(gagnant.rapport());
				System.out.println("FIN");
				System.exit (0);
			 }
		}
	}
	
	/**
	 * Methode qui permet de lancer l'action frapper en ajoutant les messages des gladiateurs agresseur et victime
	 * @param pIdAgresseur : int
	 * @param pIdVictime : int
	 * @param pIdArme: int
	 * @throws Exception Leve une erreur si le gladiateur est deja mort
	 */
	public static void frapper(int pIdAgresseur, int pIdVictime, int pIdArme) throws Exception {
		if(!gGladiateur.getGladiateur(pIdAgresseur).estMoribond() && ! gGladiateur.getGladiateur(pIdVictime).estMoribond()) {
			System.out.println(gGladiateur.getGladiateur(pIdAgresseur).messageAgresseur(gGladiateur.getGladiateur(pIdVictime), gArme.getArme(pIdArme))+"\n");
			gGladiateur.getGladiateur(pIdAgresseur).frapper(gGladiateur.getGladiateur(pIdVictime), gArme.getArme(pIdArme));
			System.out.println(gGladiateur.getGladiateur(pIdVictime).messageVictime(gGladiateur.getGladiateur(pIdAgresseur), gArme.getArme(pIdArme))+"\n");
		}
	}
}
