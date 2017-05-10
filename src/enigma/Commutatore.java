package enigma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Commutatore extends JPanel {

    private BufferedImage image;

    Commutatore() {

        this.setSize(700, 400);
        this.setLayout(null);
        this.setVisible(true);

        this.addMouseListener(new CommutatoreListener());

        try {
            image = ImageIO.read(new File("commutatore2.jpg"));    //Carico un'altra immagine
        } catch (IOException ex) {
            System.out.println("Immagine commutatore2.jpg non trovata!");
        }
    }
//Posizione degli "spinotti" di collegamento
    int y[] = {175, 223, 290};
    int x[] = {55, 125, 189, 259, 330, 399, 468, 536, 608, 87, 155, 225, 294, 367, 436, 506, 575, 55, 125, 189, 259, 330, 399, 468, 536, 608};
    public static int wichX[] = new int[14];
    public static boolean ciD = false;
    public static int wichY[] = new int[14];
    public static int count = 0;

    public void paintComponent(Graphics g) {

        g.drawImage(image, 0, 0, null);
        g.setColor(Color.red);

        if (ciD) {

            for (int i = 0; i < count; i++) {  //Impostazione del colore diverso per coppia di collegamento
                if (i < 2) {
                    g.setColor(Color.red);
                } else if (i >= 2 && i < 4) {
                    g.setColor(Color.orange);
                } else if (i >= 4 && i < 6) {
                    g.setColor(Color.green);
                } else if (i >= 6 && i < 8) {
                    g.setColor(Color.blue);
                } else if (i >= 8 && i < 10) {
                    g.setColor(Color.yellow);
                } else if (i >= 10 && i < 12) {
                    g.setColor(Color.darkGray);
                } else if (i >= 12 && i < 14) {
                    g.setColor(Color.WHITE);
                }

                g.fillOval(x[wichX[i]] + 10, y[wichY[i]] + 10, 20, 20);   //Disegna in base alla posizione passata dal Listener
                g.fillOval(x[wichX[i]] + 10, y[wichY[i]] - 20, 20, 20);

            }
        }

        setOpaque(false);
        repaint();

    }

}


//OK
