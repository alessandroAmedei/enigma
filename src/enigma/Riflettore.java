package enigma;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ale
 */
public class Riflettore {

    public int specchia(int pos) {

        //RIFLESSO puro a specchio. Ricevo una posizione e la specchio rispetto al centro.  --> A (pos. 0) == 26-(0+1) == 1 --> Z
        return 26 - (pos + 1);

    }
}
