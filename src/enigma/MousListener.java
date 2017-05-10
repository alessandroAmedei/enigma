package enigma;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Ale
 */
class MousListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

        int x = me.getX();
        int y = me.getY();

        // System.out.println(me.getX() + " " + me.getY());
        if (y < 40) {
            if (x > 40 && x < 150) {
                JOptionPane.showMessageDialog(null, "Created by Alessandro Amedei in Florence v1.0 09-01-2016 21:10, alessandroamedei18@gmail.com");
            }
        }

        if (y > 140 && y < 160) {   //Serve per impostare i rotori.

            if (x > 170 && x < 190) {
                Enigma.rotore3.shift();
                Enigma.jlr3.setText(String.valueOf(Enigma.rotore3.C[0]));
            }

            if (x > 240 && x < 260) {
                Enigma.rotore2.shift();
                Enigma.jlr2.setText(String.valueOf(Enigma.rotore2.C[0]));
            }

            if (x > 310 && x < 330) {
                Enigma.rotore1.shift();
                Enigma.jlr1.setText(String.valueOf(Enigma.rotore1.C[0]));
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

}


//OK