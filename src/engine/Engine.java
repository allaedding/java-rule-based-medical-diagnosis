/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.io.FileNotFoundException;
import java.util.Vector;

/**
 *
 * @author allagowf
 */
public class Engine {

    private Base_fait BF; // base de faits
    private Base_regle BR; // base de règles
    private Vector<Regle> BRF;
    private String trace = "";
    public String fait_file = "";
    int cpt = 0;

    public Engine(String fich_fait, String fich_regles) {
        this.BF = new Base_fait();
        this.BR = new Base_regle();
        this.BRF = new Vector<Regle>();

        this.BF.lecture(fich_fait); // appel de lecture
        this.BR.get_file(fich_regles);
        this.fait_file = fich_fait ;

    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    // getters and setters
    public Base_fait getBF() {
        return BF;
    }

    public void setBF(Base_fait BF) {
        this.BF = BF;
    }

    public Base_regle getBR() {
        return BR;
    }

    public void setBR(Base_regle BR) {
        this.BR = BR;
    }

    //*********************CHAINAGE AVANT***********************************
    // rechercher un but 
 
    public Vector<Regle> ensemble_conflit(Vector<Regle> br, Vector<String> bf, String tr) {
        BRF.clear();
        int i = 0;
        while ((BR.getListe_regle().size() > 0) && (i < 9)) {
                
            Boolean verif = false;

            // pour chaque regle on vérifie si ses prémisses existent dans la base de faits
            if (BR.getListe_regle().elementAt(i).verifier(BF.getFaits()) == true) {
                cpt = i+1;
                for (int k = 0; k < BF.getFaits().size(); k++) {

                    if (BR.getListe_regle().elementAt(i).getResultat().equals(BF.getFaits().elementAt(k))) {
                        verif = true;
                       
                        
                        tr = tr + "\n The rule is verified but the result is already in the fact base";
                        break;
                    } else {
                        verif = false;
                        
                    }
                    
                    
                }

                if (verif == false) {
                    BRF.add(BR.getListe_regle().elementAt(i));
                     
                }
            }
            
            i++;
        }
        return BRF;



    }    //ok
   
    public Regle max_premisse(Vector<Regle> vect) {

        int max = vect.elementAt(0).getPremisse().size();

        Regle R = new Regle(vect.elementAt(0).getPremisse(), vect.elementAt(0).getResultat());
        for (int i = 1; i < vect.size(); i++) {
            if (vect.elementAt(i).getPremisse().size() > max) {
                max = vect.elementAt(i).getPremisse().size();
                R = new Regle(vect.elementAt(i).getPremisse(), vect.elementAt(i).getResultat());

            }

        }
        return R;
    }  //ok

    public String saturer() throws FileNotFoundException {
// instanciation de BF et BR

        BRF = new Vector<Regle>();
        
        Regle R = null;


        Boolean init = false;
        String tr = "BF=" + this.BF.afficher();  // chaine qui permet d'afficher la trace des opérations effectuées


        BRF = ensemble_conflit(BR.getListe_regle(), BF.getFaits(), tr);
        
       
        while (BRF.size() > 0) {
            
            R = max_premisse(BRF);
            //BF.ecrire(R.getResultat(), fait_file);
            if(BF.getFaits().add(R.getResultat()))
            {
            tr = tr + "\n The rule numbrer is "+cpt+" is used and the result is : " + R.getResultat();
           // tr = tr + "\n BF=" + this.BF.afficher();
            break;
            }   
            
            
            BR.supprimer(R);
            BRF = ensemble_conflit(BR.getListe_regle(), BF.getFaits(), tr);
           
        }



        if (BRF.isEmpty()) {
            tr = tr + "Désolé, je ne connais pas votre maladie !";
        }
        return tr;
    }
    
   
}
