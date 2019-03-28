/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
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
public class Accueil extends JFrame {
    
     TextField but1;
     TextField but2;
     TextField but3;
     TextField but4;
     TextField but5;
     TextField but6;
     TextField but7;
     TextField but8;
     TextField but9;
     TextField but10;
     TextField but11;
     TextField but12;
     TextField but13;
    Checkbox c1;
    Checkbox c2;
    Checkbox c3;  
     Checkbox c4;
     Checkbox c5;
    Checkbox c6;
    Checkbox c7;  
     Checkbox c8;
        Checkbox c9;
     Checkbox c10;
    Checkbox c11;
    Checkbox c12;  
     Checkbox c13;
     BufferedWriter writer = null;

    private String chemin_bf;
    private String chemin_br;

    public String getChemin_bf() {
        return chemin_bf;
    }

    public void setChemin_bf(String chemin_bf) {
        this.chemin_bf = chemin_bf;
    }

    public String getChemin_br() {
        return chemin_br;
    }

    public void setChemin_br(String chemin_br) {
        this.chemin_br = chemin_br;
    }

    public Accueil() {
        super();

        setTitle("Welcome");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
        JPanel p0 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p13 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p14 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p15 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p16 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p17 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p18 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p19 = new JPanel(new FlowLayout(FlowLayout.LEFT));

      // JLabel l1 = new JLabel("Inference Engine order 0");

      
        JLabel l12 = new JLabel("Choose a rule base");

        JLabel l2 = new JLabel("Select your symptoms");
        
        
     c1 = new Checkbox("fatigue");
     c2 = new Checkbox("maux de ventre");
     c3 = new Checkbox("fievre");
     c4 = new Checkbox("diarrhee");
     c5 = new Checkbox("difficultes respiratoires");
     c6 = new Checkbox("douleur abdominale");
     c7 = new Checkbox("nausees");
     c8 = new Checkbox("suspicion maladie de digestion");
     c9 = new Checkbox("gorge rouge");
     c10 = new Checkbox("douleur a la racine du nez");
     c11 = new Checkbox("perte de poids");
     c12 = new Checkbox("maux de tete");
     c13 = new Checkbox("inflammation de la gorge");
     
    
    
          
           but2 = new TextField(20);
           but3 = new TextField(20);
           but4 = new TextField(20);
           but5 = new TextField(20);
           but6 = new TextField(20);
           but7 = new TextField(20);
           but8 = new TextField(20);
           but9 = new TextField(20);
           but10 = new TextField(20);
           but11 = new TextField(20);
           but12 = new TextField(20);
           but13 = new TextField(20);
           
         
                  

     //Register a listener for the check boxes.
    
        
        
      //  JLabel l3 = new JLabel("forward chaining");
        
        JButton b1 = new JButton("ok");
         JButton b2 = new JButton("upload");
       
       
        JButton bou2 = new JButton("browse");
        

        
      //  p0.add(l11);
      
        p1.add(l12);
        p1.add(bou2);
        p2.add(l2);
        p3.add(c1);
      //  p3.add(but1);
        p4.add(c2);
       // p4.add(but2);
        p5.add(c3);
      //  p5.add(but3);
        p8.add(c4);
      //  p8.add(but4);
        
        p9.add(c5);
     //   p9.add(but5);
        p10.add(c6);
     //   p10.add(but6);
        p11.add(c7);
     //   p11.add(but7);
        p12.add(c8);
     //   p12.add(but8); 
        p13.add(c9);
      //  p8.add(but9);
        
        p14.add(c10);
     //   p9.add(but10);
        p15.add(c11);
     //   p10.add(but11);
        p16.add(c12);
     //   p11.add(but12);
        p17.add(c13);
     //   p12.add(but13); 
        p6.add(b2);
     //   p6.add(l3);
        p7.add(b1);
        
       


    
        bou2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();

//intitulé du bouton
                chooser.setApproveButtonText("file chosen");
//affiche la boite de dialogue 
                chooser.showOpenDialog(null);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    chemin_br = chooser.getSelectedFile().getAbsolutePath();
                    //
                    chemin_bf = chemin_br.replace("Rule_Base.txt","Fact_Base.txt");
                }
            }
        });
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Avant a = new Avant();
                a.setChem_bf(chemin_bf);
                a.setChem_br(chemin_br);
            }
        });
        
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            
                   
           if(c1.getState()){but1.setText(","+c1.getLabel());} else but1.setText("");
           if(c2.getState()){but2.setText(","+c2.getLabel());} else but2.setText("");
           if(c3.getState()){but3.setText(","+c3.getLabel());} else but3.setText("");
           if(c4.getState()){but4.setText(","+c4.getLabel());} else but4.setText("");
           if(c5.getState()){but5.setText(","+c5.getLabel());} else but5.setText("");
           if(c6.getState()){but6.setText(","+c6.getLabel());} else but6.setText("");
           if(c7.getState()){but7.setText(","+c7.getLabel());} else but7.setText("");
           if(c8.getState()){but8.setText(","+c8.getLabel());} else but8.setText("");
           if(c9.getState()){but9.setText(","+c9.getLabel());} else but9.setText("");
           if(c10.getState()){but10.setText(","+c10.getLabel());} else but10.setText("");
           if(c11.getState()){but11.setText(","+c11.getLabel());} else but11.setText("");
           if(c12.getState()){but12.setText(","+c12.getLabel());} else but12.setText("");
           if(c13.getState()){but13.setText(","+c13.getLabel());} else but13.setText("");
     
                     String fait_txt =""+but1.getText() +""+but2.getText()+""+but3.getText()+""+but4.getText()+""+but5.getText()+""+but6.getText()+""+but7.getText()+""+but8.getText()+""+but9.getText()+""+but10.getText()+""+but11.getText()+""+but12.getText()+""+but13.getText() ;
                    
                    ecrire (fait_txt,chemin_bf);
                
                }
                
            
        });
        
        

        
setLayout(new GridLayout(20,1));
       // add(p0);
        add(p1);
        add(p0);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p8);
        add(p9);
        add(p10);
        add(p11);
        add(p12);
         add(p13);
        add(p14);
        add(p15);
        add(p16);
        add(p17);
        add(p18);
        add(p19);
        add(p6);
        add(p7);
        
        setVisible(true);


    }
    
    private void ecrire (String fait, String fichier) {
            try {
           } catch (Exception e) {
}
           
finally {
            try {
                 writer = new BufferedWriter(new FileWriter(fichier));
            writer.write(""+fait);
                writer.close();
            } catch (IOException e) {
            }
}
    }

    public static void main(String[] args) {
        Accueil a = new Accueil();


    }
}
