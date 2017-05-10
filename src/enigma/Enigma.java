package enigma;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author Ale
 */
public class Enigma extends JPanel {

    private BufferedImage image;

    public static JLabel jlr1 = new JLabel();
    public static JLabel jlr2 = new JLabel();
    public static JLabel jlr3 = new JLabel();

    public static Rotore rotore1;
    public static Rotore rotore2;
    public static Rotore rotore3;
    public static Riflettore riflettore;

    Enigma() {
        this.setSize(700, 740);
        this.setLayout(null);
        this.setVisible(true);

        char[] R1 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int[] n1 = {1, 3, 7, 4, 2, 3, 9, -2, -6, -9, 4, 6, 8, 11, -3, -5, 0, -4, 1, -1, -8, -18, 0, -2, 1, -2};  //RAPPRESENTO I COLLEGAMENTI TRA FACCIA E FACCIA DEL ROTORE
        int[] n2 = {9, -1, 6, 18, -3, 2, -2, -4, -3, -7, 5, 3, 8, 4, -4, -9, 0, -6, 1, -1, -8, 2, 0, 2, -11, -1};

        System.out.println("Enigma si avvia..." + R1.length + " " + n1.length + " " + n2.length); //Un pò di debug..

        rotore1 = new Rotore(n1, n2);   //Creo i tre rotori e gli assegno ad ognuno i collegamenti tra 'piatto' e 'piatto'

        rotore2 = new Rotore(n1, n2);

        rotore3 = new Rotore(n1, n2);

        riflettore = new Riflettore();

        try {
            image = ImageIO.read(new File("enigma2.jpg"));     //Carico l'immagine
        } catch (IOException ex) {
            System.out.println("Immagine enigma1.png non trovata!");
        }

        jlr1.setSize(50, 50);           //Imposto le label sull'immagine per rappresentare la posizione dei rotori
        jlr2.setSize(50, 50);
        jlr3.setSize(50, 50);

        jlr1.setLocation(313, 180);
        jlr2.setLocation(247, 180);
        jlr3.setLocation(179, 180);

        jlr1.setText(String.valueOf(rotore1.C[0]));
        jlr2.setText(String.valueOf(rotore2.C[0]));
        jlr3.setText(String.valueOf(rotore3.C[0]));

        JButton b = new JButton("commuta");
        b.setSize(100, 70);
        b.setLocation(600, 650);
        b.setVisible(true);
        b.addActionListener(new ActionListener() {    //Semplice bottone per far apparire la finestra della commutazione

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Main.f2.setVisible(true);

            }
        });

        this.add(jlr1);
        this.add(jlr2);
        this.add(jlr3);
        this.add(b);

        this.addMouseListener(new MousListener());
        this.addKeyListener(new KeyBoardListener());

        JLabel name = new JLabel("<html><font color='red'>AMEDEI<br>ALESSANDRO<br>5AIT<br>01/2016</font></html>");
        name.setSize(150, 100);
        name.setLocation(97, 0);
        name.setVisible(true);
        this.add(name);
    }
    int r1 = 0;
    int r2 = 0;
    int r3 = 0;

    public char cifra(char c) {
        int pos = c - 65;

        //Un rotore riceve in ingresso una posizione e ne fa uscire un'altra di conseguenza. Fatto con i tre rotori in un senso, poi riflettendo, e successivamente a ritroso, con commutazione, otteniamo enigma!
        int finalPos = rotore1.right(rotore2.right(rotore3.right(riflettore.specchia(rotore3.left(rotore2.left(rotore1.left(pos)))))));

        //Ogni cifratura si shifta il primo rotore di una posizione, il secondo shifterà di uno quando il primo avrà compiuto un giro e cosi via
        Main.enigma.rotore1.shift();
        Enigma.jlr1.setText(String.valueOf(Enigma.rotore1.C[0]));
        r1++;
        if (r1 == 25) {
            r1 = 0;
            r2++;
            Main.enigma.rotore2.shift();
            Enigma.jlr2.setText(String.valueOf(Enigma.rotore2.C[0]));

        }
        if (r2 == 25) {
            r2 = 0;
            r3++;
            Main.enigma.rotore3.shift();
            Enigma.jlr3.setText(String.valueOf(Enigma.rotore3.C[0]));

        }

        return (char) (finalPos + 65);

    }
    public static char[] c1 = new char[26];
    public static char[] c2 = new char[c1.length];

    public char commuta(char c) {

//Semplice funzione che passatogli un carattere ce ne rende un'altro associato (1:1)
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == c) {
                return c2[i];
            }

            if (c2[i] == c) {
                return c1[i];
            }
        }
        return c;
    }

    int y[] = {320, 379, 440};

    int x[] = {95, 159, 224, 287, 349, 414, 478, 541, 607, 128, 192, 252, 316, 384, 447, 510, 579, 95, 159, 224, 287, 349, 414, 478, 541, 607};
    public static int draw;
    public static boolean ciD = false;
    public static int wichY;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setFocusable(true);
        this.requestFocusInWindow();

        g.drawImage(image, 0, 0, null);

        g.setColor(Color.red);    //IF CAN I DRAW? DISEGNA NELLE POSIZIONI DATE DAL LISTENER..
        if (ciD) {
            g.fillOval(x[draw] - 20, y[wichY] - 20, 40, 40);//Before it was fillDraw function.

        }

        repaint();
    }

}


//OK