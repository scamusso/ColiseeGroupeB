/**
 * 
 */
package vue;

import java.util.ArrayList;

import controlleur.GArme;
import modele.Arme;
import modele.Gladiateur;
import modele.Retiaire;

/**
 * @author 1782580
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Test Class Arme OK
		/*
		Arme arme = new Arme( 1, "Glaive", 80, 7);
		System.out.println(arme.description());
		
		System.out.println(arme.getNomArme());
		System.out.println(arme.getPuissanceOffensive());
		System.out.println(arme.getIdArme());
		System.out.println(arme.getPuissanceDefensive());
		
		arme.setPuissanceOffensive(50);
		System.out.println(arme.getPuissanceOffensive());
		arme.setPuissanceDefensive(25);
		System.out.println(arme.getPuissanceDefensive());*/
		
		//Test Class GArme OK
		
		GArme gArme = new GArme();
		Arme arme = gArme.ajouterArme("Trident", 100, 0);
		System.out.println(arme.description());
		
		
		Arme arme2 = gArme.ajouterArme("Filet", 40, 20);
		System.out.println(arme2.description());
		
		Arme getArme = gArme.getArme(2);
		System.out.println(getArme.description());
		
		ArrayList<Arme> toutesLesArmes = gArme.getToutesLesArmes();
		for(Arme uneArme : toutesLesArmes) {
			System.out.println(uneArme.description());
		}
		
		
		//Test Gladiator
		Gladiateur retiaire = new Retiaire(1, "Unix", 30);
		Gladiateur victime = new Retiaire(2, "Informatix", 40);
		
		//Getters
		/*System.out.println(retiaire.getcVieInitiale());
		System.out.println(retiaire.getForce());
		System.out.println(retiaire.getMesAggresseurs());
		System.out.println(retiaire.getMesArmes());
		System.out.println(retiaire.getNom());
		System.out.println(retiaire.getType());
		System.out.println(retiaire.getVie());
		
		//Setters
		retiaire.setcVieInitiale(300);
		System.out.println(retiaire.getcVieInitiale());
		retiaire.setVie(100);
		System.out.println(retiaire.getVie());
		
		retiaire.setMesArmes(toutesLesArmes);
		System.out.println(retiaire.getMesArmes());
		
		
		System.out.println(retiaire.declarerMesArmes());
		System.out.println(retiaire.estBienPortant());
		System.out.println(retiaire.estBlesse());
		System.out.println(retiaire.estMoribond());
		
		System.out.println("rapport");
		System.out.println(retiaire.rapport());
		System.out.println("rapport victime");
		System.out.println(victime.rapport());
		
		retiaire.frapper(victime, arme2);
		System.out.println("rapport victime apres frappe");
		System.out.println(victime.rapport());
		
		System.out.println("get vie");
		System.out.println(retiaire.getVie());*/
		
		retiaire.recevoirArme(arme);
		System.out.println(retiaire.rapport());
		System.out.println("rapport victime");
		System.out.println(retiaire.rapport());
		retiaire.recevoirCoup(victime, 100);
		System.out.println(retiaire.rapport());
		
		
	}

}
