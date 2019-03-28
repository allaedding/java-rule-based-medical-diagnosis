/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Vector;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author allagowf
 */
public class Base_fait {
     BufferedWriter writer = null;
    private Vector <String> faits; // vecteur de faits
// constructeur, getters and setters
    public Base_fait() {
    }
    
     public Vector<String> getFaits() {
        return faits;
    }

    public void setFaits(Vector<String> faits) {
        this.faits = faits;
    }
    
    // fonction qui lit le fichier base de fait et remplit le vecteur faits 
    public void lecture (String fichier){
        // initialisation des vecteurs
          Vector<String> v= new Vector<String>();
          this.faits= new Vector<String>();
        try {
	         
	          // lecture du fichier
	         
	            InputStream ips = new FileInputStream(fichier);
	            InputStreamReader ipsr = new InputStreamReader(ips);
	            BufferedReader br = new BufferedReader(ipsr);
	            String ligne;
	            // lire tant que la ligne n'est pas vide
	            while ((ligne = br.readLine()) != null) {
                    // on sépare les faits at on les mets dans un tableau
	            	String[] tokens = ligne.split(",");
                    // on les copie dans un vecteur
	            for (int i=0; i<tokens.length;i++){
                      
                    v.add(tokens[i]);
                        
	            }
	            
	            } 
		 } catch (Exception e) {
	            System.out.println(e.toString());
	        }
        //on copie le vecteur intermédiare dans faits 
     for (int i=0;i<v.size();i++){
        this.faits.insertElementAt(v.elementAt(i), i);
    }    
  
    }
    
    
    
  
    // fonction qui un ecrit un fait dans le fichier base de faits
   
    public void ecrire (String fait, String fichier) throws FileNotFoundException{
        PrintStream out =new PrintStream(new FileOutputStream(fichier, true));
        out.append(","+fait);
    }
    
    
  /*   public void ecrire (String fait, String fichier) {
              try {
           } catch (Exception e) {
    e.printStackTrace(); }
           
finally {
            try {
                 writer = new BufferedWriter(new FileWriter(fichier));
            writer.write(","+fait);
                writer.close();
            } catch (Exception e) {
            }
}
    } */
    
    
    
    
    // retourne une chaine qui contient les faits séparé par ","
    public String afficher(){
        String s="";
        for (int i=0;i<this.faits.size();i++){
            
            s= s+(this.faits.elementAt(i)+",");
        }
        return s;
    }
    
  
   
    

}
