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
public class Rotore {

    public char[] C = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private int staticnL[];
    private int staticnR[];
    private int nL[];
    private int nR[];
    private int position = 0;

    Rotore(int[] n, int[] n2) {

        nL = n;         //Ogni rotore ha i suoi shift
        nR = n2;
        staticnL = n;
        staticnR = n2;

    }

    public int left(int pos) {     //""PASSAGGIO DI CORRENTE"" DA DESTRA A SINISTRA

        if (pos + nL[pos] > 25) {                                                 //MI RITORNI LA POSIZIONE DI INGRESSO PIU' LO SHIFT
            // return pos + nL[pos] - 26;  Seguiamo le formule della Batta..
            return (pos + nL[pos]) % 26;
        }

        if (pos + nL[pos] < 0) {
            return 26 + (pos + nL[pos]);  //ERROREEE DOPPIO
        }

        return pos + nL[pos];
    }

    public int right(int pos) {   //STESSA COSA AL CONTRARIO

        if (pos + nR[pos] > 25) {
            //   return pos + nR[pos] - 26;
            return (pos + nR[pos]) % 26;
        }

        if (pos + nR[pos] < 0) {
            return 26 + (pos + nR[pos]);  //ERROREEE DOPPIOO
        }

        return pos + nR[pos];
    }

    public void imposta(int pos) {   //Fa uno shift rispettando le posizioni iniziali

        nL = new int[staticnL.length];
        nR = new int[staticnR.length];

        for (int i = 0, n = pos; i < staticnL.length; i++, n++) {
            if (n == staticnL.length) {
                n = 0;
            }

            nL[n] = staticnL[i];
            nR[n] = staticnR[i];

        }

    }

    public void shift() {   //Eseguo uno shift di uno in "avanti"

        int[] newnL = new int[nL.length];
        int[] newnR = new int[nR.length];
        char[] newC = new char[C.length];

        for (int i = 0, n = 1; i < staticnL.length; i++, n++) {
            if (n == staticnL.length) {
                n = 0;
            }

            newnL[n] = nL[i];
            newnR[n] = nR[i];
            newC[n] = C[i];

        }

        nL = newnL;
        nR = newnR;
        C = newC;
        //   printArray();
    }

}

//OK
