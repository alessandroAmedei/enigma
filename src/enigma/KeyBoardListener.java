package enigma;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 *
 * @author Ale
 */
class KeyBoardListener implements KeyListener {

    char alf1[] = {'Q', 'W', 'E', 'R', 'T', 'Z', 'U', 'I', 'O', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'P', 'Y', 'X', 'C', 'V', 'B', 'N', 'M', 'L'};
    char alf2[] = {};    //Lettere enigma
    int a = 0;

    boolean isStillPressed = false;

    File yourFile = new File("type.wav");  //Carica l'audio
    AudioInputStream stream;
    AudioFormat format;
    DataLine.Info info;
    Clip clip;

    @Override
    public void keyTyped(KeyEvent ke) {

    }
    int al;

    @Override
    public void keyPressed(KeyEvent ke) {
        if (isStillPressed) {   //Se non è stato rilasciato non fare niente
            return;
        }

        isStillPressed = true;

        char readC = ke.getKeyChar();
        if (readC > 96 && readC < 123) {   ///Leggi il carattere, solo se è maiuscolo o minuscolo, se minuscolo trasforma in maiuscolo
            al = (int) readC - 32;
            readC = (char) al;
        }
        if (readC > 64 && readC < 91) {
            //START.. ABC = SVV

            //Cifra e commuta
            char c = Main.enigma.commuta(Main.enigma.cifra(Main.enigma.commuta(readC)));  //Doppia commutazione.. * Manca grafica sketch

            a++;                      //DEBUG
            System.out.print(c);
            if (a == 20) {
                System.out.println(" ");
                a = 0;
            }

            for (int i = 0; i < alf1.length; i++) {   //Passa le di dove la "lampadina" deve essere accesa
                if (c == alf1[i]) {

                    Enigma.draw = i;
                    Enigma.ciD = true;
                    if (i < 9) {
                        Enigma.wichY = 0;    //Su che cordinata y?
                    } else if (i > 8 && i < 17) {
                        Enigma.wichY = 1;
                    } else if (i > 16) {
                        Enigma.wichY = 2;
                    }

                }

            }
            //riproduzione suono

            try {
                stream = AudioSystem.getAudioInputStream(yourFile);  //Riproduci uno stream audio
                format = stream.getFormat();
                info = new DataLine.Info(Clip.class, format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(stream);
                clip.start();
            } catch (Exception e) {
                //whatevers 
                System.out.println("File type.wav non trovato");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

        //Rilasciato il tasto, smetti di disegnare. CanIDraw= false
        Enigma.ciD = false;

        isStillPressed = false;

    }

}

//OK