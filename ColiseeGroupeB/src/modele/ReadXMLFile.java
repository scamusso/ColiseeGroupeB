package modele;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLFile {
    public static void main(final String[] args) {
        /*
         * Etape 1 : récupération d'une instance de la classe "DocumentBuilderFactory"
         */
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            	
	        try {
	            /*
	             * Etape 2 : création d'un parseur
	             */
	            final DocumentBuilder builder = factory.newDocumentBuilder();
				
		    /*
		     * Etape 3 : création d'un Document
		     */
		    final Document document= builder.parse(new File("jeuDEssai.xml"));
				
						
		    /*
		     * Etape 4 : récupération de l'Element racine
		     */
		    final Element racine = document.getDocumentElement();
			
		    //Affichage de l'élément racine
		    System.out.println("\n*************RACINE************");
		    System.out.println(racine.getNodeName());
			
		    /*
		     * Etape 5 : récupération des personnes
		     */
		    final NodeList racineNoeuds = racine.getChildNodes();
		    final int nbRacineNoeuds = racineNoeuds.getLength();
				
		    for (int i = 0; i<nbRacineNoeuds; i++) {
		        if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
		            final Element gladiateurs = (Element) racineNoeuds.item(i);
					
				    	 /*
					     * Etape 6 : récupération du nom et du prénom
					     */
			    
					    final Element gladiateur = (Element) gladiateurs.getElementsByTagName("gladiateur").item(0);
					    //final Element armedugladiateur = (Element) gladiateur.getElementsByTagName("arme");
					    NodeList armedugladiateur = gladiateur.getElementsByTagName("arme");
					    final int nbarmedugladiateur = armedugladiateur.getLength();
						for(int j=0;j<=nbarmedugladiateur;j++)
						{
							System.out.println("armedugladiateur : " + armedugladiateur.item(j));

						}
								
					    //Affichage du nom et du prénom
					    System.out.println("gladiateur : " + gladiateur.getTextContent());
					    
								
					    /*
					     * Etape 7 : récupération des numéros de téléphone
					     */
			    /*
					    final NodeList telephones = personne.getElementsByTagName("telephone");
					    final int nbTelephonesElements = telephones.getLength();
								
					    for(int j = 0; j<nbTelephonesElements; j++) {
					        final Element telephone = (Element) telephones.item(j);
					    
			                        //Affichage du téléphone
			                        System.out.println(telephone.getAttribute("type") + " : " + telephone.getTextContent());
					    }	
					    		
			        }	
			        	*/		
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
}
