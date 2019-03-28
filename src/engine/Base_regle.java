/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author allagowf
 */
public class Base_regle {
    
    private Vector <Regle> liste_regle; // vecteur de règles
// getter and setter
    public Vector<Regle> getListe_regle() {
        return liste_regle;
    }

    public void setListe_regle(Vector<Regle> liste_regle) {
        this.liste_regle = liste_regle;
    }
    
    // lire le fichier base de règles et remplire le vecteur liste_regle
    public void get_file (String fichier) {
        // initialisation des vecteurs
        Vector<Regle> v= new Vector<Regle>();
         this.liste_regle=new Vector<Regle>();
         try {
             // lecture du fichier
	    InputStream ips = new FileInputStream(fichier);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;   
            
	        // lecture tant que la ligne est non vide    
	    while ((ligne = br.readLine()) != null) {
                //On sépare les prémisses du résultat
                String[] tokens = ligne.split("=");
                // on met les prémisses dans un tableau
                String [] prem =tokens[0].split(",");
                // on met les prémisses dans un vecteur
               Vector <String> premi = new  <String>Vector(); 
                for (int i=0;i<prem.length;i++){
                    premi.add(prem[i]);
                }
                // on met le resultat dans une chaine
                String res = tokens[1];
                // on construit la regle de cette ligne
                Regle reg = new Regle(premi,res);
              // on ajoute la règle dans le vecteur
               v.add(reg);
               
                }
            }
         catch (Exception e) {
	            System.out.println(e.toString());
	        }
         // on copie le vecteur v dans liste_regle
    for (int i=0;i<v.size();i++){
        this.liste_regle.insertElementAt(v.elementAt(i), i);
    }    
       
}
    // supprime la règle du vecteur
    public void supprimer (Regle reg){
        this.liste_regle.remove(reg);
    }
    

  
}