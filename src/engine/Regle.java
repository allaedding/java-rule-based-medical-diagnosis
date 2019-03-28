/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.util.Vector;

/**
 *
 * @author allagowf
 */
public class Regle {

    /**
     * @param args the command line arguments
     */
    private Vector <String>  premisse; // vecteur de premisses
    private String resultat ; // resultat de la regle
    
//constructeur
    public Regle(Vector<String> premisse, String resultat) {
        
        this.premisse = premisse;
        this.resultat = resultat;
    }
   
    
// getters and setters
    public Vector<String> getPremisse() {
        return premisse;
    }

    public void setPremisse(Vector <String> premisse) {
        this.premisse = premisse;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
// fonction qui prend un vecteur en paramètre (faits) et qui vérifie si tous les prémisses sont dans le vecteur
     public Boolean verifier(Vector<String> elements){
        int j=0;
        // parcours des deux vecteurs
        for(int i=0; i<this.premisse.size();i++){
            for (j=0;j<elements.size();j++){
                // si on trouve l'élément on passe à l'itération suivante
                if(this.premisse.elementAt(i).equals(elements.elementAt(j)))
                    break;
                
            }
           // si j est arrivée à la fin du vecteur c'est qu'on a pas trouvé le fait
           if (j==elements.size())
               return false;
        }
        
     return true;   
    }
       public String afficheRegle(){
         String r="";
         for (int i=0;i<this.premisse.size();i++){
             r=r+this.premisse.elementAt(i)+",";
         }
         r=r+"="+this.resultat;
         return r;
     }
     
     
     public Boolean VerifBut (String but){
         if (this.resultat.equals(but)){
             return true;
         }
         return false;
         
     }
    

}
