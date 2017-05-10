package enigma;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JFrame;

/**
 *
 * @author Ale
 */
public class Main {

    public static Enigma enigma;
    public static Commutatore commutatore;
    public static JFrame f2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        //Creazione delle finestre e dei vari componenti con set delle impostazioni

        JFrame f = new JFrame();
        f2 = new JFrame();
        enigma = new Enigma();
        commutatore = new Commutatore();

        f.setSize(700, 740);
        f.setLayout(null);
        f.setVisible(true);
        f.add(enigma);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f2.setSize(700, 400);
        f2.setLayout(null);
        f2.setVisible(false);
        f2.add(commutatore);
        f.setResizable(false);
        f2.setResizable(false);

    }

}
//ALESSANDRO AMEDEI 08/01/2016

//09/01/2016
//11/01/2016 Aggiunto suono..Risolto problema loop typing con variabile booleana,fichè non vi è il relased non si può rieseguire il pressed.. 
//13/01/2016 Aggiunta commutazione da codice.. Tutte le volte che entra o esce una lettera dal rotore vado a controllare se deve essere sostituita.
//Manca la parte grafica (pannello frontale di enigma) .. Aggiunto suono for any typed. 
//16/01/2016 Aggiunto commutatore funzionante! FINE DEL PROGETTO..

//AlessandroAmedei ZEHXZKIICEILXAAZ OKLAST55330697


//OK

//TEST PASSED 16012016 212855 55330697 ALESSANDROAMEDEI