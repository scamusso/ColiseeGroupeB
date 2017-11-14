package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import controlleur.Facade;
import controlleur.GArme;
import controlleur.GGladiateur;

/**
 * Lecture d'un fichier XML et instanciation des gladiateurs et armes qu'il contient
 * @author Aline
 *
 */
public class ReadXMLFile {
	
	private static ArrayList<Gladiateur> gladiateursDuFichier;
	private static ArrayList<Arme> armesDuFichier;
	 
	/**
	 * Constructeur
	 * @param filepath chemin d'acces au fichier XML
	 * @throws Exception
	 */
    public ReadXMLFile(String filepath) throws Exception {
    	
    	
    	//@TODO Fichier trouvé ?
    	/*File file = new File(filepath);
    	try{
    		file.exists();
    		String canonicalName = file.getCanonicalFile().getName();
      	  	return canonicalName.equals(filepath);
    	}catch(Exception e){
    		return false;
    	}
    	*/
    	//@TODO Fichier Xml ?
    	
        //Recuperation d'une instance de la classe "DocumentBuilderFactory"
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            	
	        try {
	            //Creation d'un parseur
	            final DocumentBuilder builder = factory.newDocumentBuilder();
				
		    //Creation d'un Document
		    final Document document= builder.parse(new File(filepath));
		   
						
		    //Recuperation de l'Element racine
		    final Element racine = document.getDocumentElement();
			
		    //Recuperation des noeuds
		    final NodeList racineNoeuds = racine.getChildNodes();
		    final int nbRacineNoeuds = racineNoeuds.getLength();
		    
		    
				
		    for (int i = nbRacineNoeuds-1; i>=0; i--) {
		    	
		        if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
		            
		        	if(racineNoeuds.item(i).getNodeName().equals("gladiateurs")){
		        		
		        		// Noeud contenant les gladiateurs
		            	final Element gladiateurs = (Element) racineNoeuds.item(i);
		            	gladiateursDuFichier = this.getGladiateursFromDOM(gladiateurs);
		        		
		            }else if(racineNoeuds.item(i).getNodeName().equals("armes")){
				    	
		            	// Noeud contenant les armes
		            	final Element armes = (Element) racineNoeuds.item(i);
		            	armesDuFichier = this.getArmesFromDOM(armes);
		            	
				    }
			    }	
	        }
        }
        catch (final ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (final SAXException e) {
            e.printStackTrace();
        }
        catch (final IOException e) {
            e.printStackTrace();
        }		
    }
    
    private static ArrayList<Gladiateur> getGladiateursDuFichier() {
		return gladiateursDuFichier;
	}

	private static void setGladiateursDuFichier(ArrayList<Gladiateur> gladiateursDuFichier) {
		ReadXMLFile.gladiateursDuFichier = gladiateursDuFichier;
	}

	private static ArrayList<Arme> getArmesDuFichier() {
		return armesDuFichier;
	}

	private static void setArmesDuFichier(ArrayList<Arme> armesDuFichier) {
		ReadXMLFile.armesDuFichier = armesDuFichier;
	}

	/**
     * Recupere la liste des gladiateurs du fichier xml et les instancies puis stocke tous les gladiateurs instanciees dans un tableau
     * @param gladiateurs noeuds XML contenant les gladiateurs
     * @return tableau des gladiateurs instanciees
     * @throws Exception
     */
    public ArrayList getGladiateursFromDOM(Element gladiateurs) throws Exception{
    	ArrayList<Gladiateur> gladiateursDuDOM = new ArrayList<>();
    	    	
    	//premier gladiateur
    	final NodeList gladiateurNoeuds = gladiateurs.getElementsByTagName("gladiateur");
	    final int nbgladiateurNoeuds = gladiateurNoeuds.getLength();
	    for (int j = 0; j<nbgladiateurNoeuds; j++){
	    	
		    final Element gladiateur = (Element) gladiateurNoeuds.item(j);
		    NodeList armedugladiateur = gladiateur.getElementsByTagName("arme");
		    final int nbarmedugladiateur = armedugladiateur.getLength();
	    	
		    //Affichage des infos du gladiateur
		    int idGladiateur = Integer.parseInt(gladiateur.getAttribute("id"));
		    
		    final Element type = (Element) gladiateur.getElementsByTagName("type").item(0);
		    String typeGladiateur = type.getTextContent();
		    
		    final Element nom = (Element) gladiateur.getElementsByTagName("nom").item(0);
		    String nomGladiateur = nom.getTextContent();
		   		 
		   
		    if(typeGladiateur.equals("retiaire")){
		    	final Element agilite = (Element) gladiateur.getElementsByTagName("agilite").item(0);
		    	int agiliteGladiateur = Integer.parseInt(agilite.getTextContent());
		    	
		    	gladiateursDuDOM.add(GGladiateur.ajouterRetiaire(idGladiateur, nomGladiateur, agiliteGladiateur));
		    	
		    }else{
		    	
		    	final Element poids = (Element) gladiateur.getElementsByTagName("poids").item(0);
			    int poidsGladiateur = Integer.parseInt(poids.getTextContent());
			    
		    	gladiateursDuDOM.add(GGladiateur.ajouterMirmillon(idGladiateur, nomGladiateur, poidsGladiateur));
		    	
		    }
		    
		    
		    
		    // Info armes
			for(int k=0;k<nbarmedugladiateur;k++)
			{
				Element e = (Element)armedugladiateur.item(k);
				int idArme = Integer.parseInt(e.getAttribute("id"));
				
				Arme currentArme = GArme.getArme(idArme);
				
				gladiateursDuDOM.get(gladiateursDuDOM.size()-1).recevoirArme(currentArme);
			}
	    }
    	return gladiateursDuDOM;
    	
    }
    
    /**
     * Recupere la liste d'armes du fichier xml et les instancies puis stocke toutes les armes instanciees dans un tableau
     * @param armes noeuds XML contenant les armes
     * @return tableau des armes instanciees
     * @throws Exception
     */
	public ArrayList getArmesFromDOM(Element armes) throws Exception{
    	ArrayList<Arme> armesDuDOM = new ArrayList<>();
    	
    	final NodeList armeNoeuds = armes.getElementsByTagName("arme");
	    final int nbarmeNoeuds = armeNoeuds.getLength();
	    
	    //Pour chaque noeud du DOM Xml contenant une arme, recupere les infos pour instancier l'arme
	    for (int j = 0; j<nbarmeNoeuds; j++){
	    	Element arme = (Element)armeNoeuds.item(j);
			int idArme = Integer.parseInt(arme.getAttribute("id"));
			
			final Element nom = (Element) arme.getElementsByTagName("nom").item(0);
		    String nomArme = nom.getTextContent();
		    
		    final Element puissancOffensive = (Element) arme.getElementsByTagName("puissancOffensive").item(0);
		    int puissancOffensiveArme = Integer.parseInt(puissancOffensive.getTextContent());
		    
		    final Element puissanceDefensive = (Element) arme.getElementsByTagName("puissanceDefensive").item(0);
		    int puissanceDefensiveArme = Integer.parseInt(puissanceDefensive.getTextContent());
		   
		    Arme nouvelleArme = GArme.ajouterArme(idArme, nomArme, puissancOffensiveArme, puissanceDefensiveArme);
		    
		    armesDuDOM.add(nouvelleArme);
	    }
	    
		return armesDuDOM;
    }
}
