package enigma;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class CommutatoreListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    char alf1[] = {'Q', 'W', 'E', 'R', 'T', 'Z', 'U', 'I', 'O', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'P', 'Y', 'X', 'C', 'V', 'B', 'N', 'M', 'L'};
    int y[] = {180, 234, 285};  //Cordinate spinotti
    int x[] = {55, 125, 189, 259, 330, 399, 468, 536, 608, 87, 155, 225, 294, 367, 436, 506, 575, 55, 125, 189, 259, 330, 399, 468, 536, 608};
    int range = 15;

    @Override
    public void mousePressed(MouseEvent arg0) {

        if (Commutatore.count == 14) {  //Massimo 7 coppie
            JOptionPane.showMessageDialog(null, "Si possono inserire al massimo 7 coppie");
            return;
        }

        System.out.println(arg0.getX() + "  " + arg0.getY());

        int xc = arg0.getX();
        int yc = arg0.getY();

        System.out.println(xc + " >>> " + yc);

        if (yc - range < y[0] && yc + range > y[0]) {   //Per la prima linea

            for (int nx = 0; nx < 9; nx++) {

                if (xc - range < x[nx] && xc + range > x[nx]) {

                    Commutatore.wichX[Commutatore.count] = nx;   //Passa al pannello le cordinate di dove dovrà disegnare
                    Commutatore.wichY[Commutatore.count] = 0;
                    Commutatore.count++;
                    Commutatore.ciD = true;
                    break;

                }

            }

        }

        if (yc - range < y[1] && yc + range > y[1]) {  //Per la seconda

            for (int nx = 9; nx < 17; nx++) {

                if (xc - range < x[nx] && xc + range > x[nx]) {

                    Commutatore.wichX[Commutatore.count] = nx;
                    Commutatore.wichY[Commutatore.count] = 1;
                    Commutatore.count++;
                    Commutatore.ciD = true;
                    break;

                }

            }

        }

        if (yc - range < y[2] && yc + range > y[2]) {  //Per la terza

            for (int nx = 17; nx < 25; nx++) {

                if (xc - range < x[nx] && xc + range > x[nx]) {

                    Commutatore.wichX[Commutatore.count] = nx;
                    Commutatore.wichY[Commutatore.count] = 2;
                    Commutatore.count++;
                    Commutatore.ciD = true;
                    break;

                }

            }

        }

        if (Commutatore.count == 2) {  //Ogni volta che una coppia è stata creata inserisci nei vettori c1 e c2 le due lettere selezionate per metterle in comune

            Main.enigma.c1[0] = alf1[Commutatore.wichX[0]];
            Main.enigma.c2[0] = alf1[Commutatore.wichX[1]];
            System.out.println("ok1 " + Main.enigma.c1[0] + " " + Main.enigma.c2[0]);
        }

        if (Commutatore.count == 4) {
            Main.enigma.c1[1] = alf1[Commutatore.wichX[2]];
            Main.enigma.c2[1] = alf1[Commutatore.wichX[3]];

        }

        if (Commutatore.count == 6) {
            Main.enigma.c1[2] = alf1[Commutatore.wichX[4]];
            Main.enigma.c2[2] = alf1[Commutatore.wichX[5]];

        }

        if (Commutatore.count == 8) {
            Main.enigma.c1[3] = alf1[Commutatore.wichX[6]];
            Main.enigma.c2[3] = alf1[Commutatore.wichX[7]];

        }

        if (Commutatore.count == 10) {
            Main.enigma.c1[4] = alf1[Commutatore.wichX[8]];
            Main.enigma.c2[4] = alf1[Commutatore.wichX[9]];

        }

        if (Commutatore.count == 12) {
            Main.enigma.c1[5] = alf1[Commutatore.wichX[10]];
            Main.enigma.c2[5] = alf1[Commutatore.wichX[11]];

        }

        if (Commutatore.count == 14) {
            Main.enigma.c1[6] = alf1[Commutatore.wichX[12]];
            Main.enigma.c2[6] = alf1[Commutatore.wichX[13]];

        }

    }

    @Override
    public void mouseReleased(MouseEvent arg0
    ) {
        // TODO Auto-generated method stub

    }

}

/*for(int i=0;i<x.length;i++) {
if(xc-5 < x[i] && xc+5 > x[i] ) {
	
	
	
	Commutatore.draw[Commutatore.count]=i;
	Commutatore.ciD=true;
	if(xy-5 < y[0] && xy+5 > y[0])
	Commutatore.wichY[Commutatore.count]=0;
	if(xy-5 < y[1] && xy+5 > y[1])
		Commutatore.wichY[Commutatore.count]=1;
	if(xy-5 < y[2] && xy+5 > y[2])
		Commutatore.wichY[Commutatore.count]=2;
	
	Commutatore.count++;
	
	if(Commutatore.count==2){
		
		
		
		Main.enigma.c1[0]=alf1[Commutatore.draw[0]];
		Main.enigma.c2[0]=alf1[Commutatore.draw[1]];
		System.out.println("ok1 " + Main.enigma.c1[0] + " "+ Main.enigma.c2[0]);
	}
		
	if(Commutatore.count==4){
		Main.enigma.c1[1]=alf1[Commutatore.draw[2]];
		Main.enigma.c2[1]=alf1[Commutatore.draw[3]];

	}
	break;
}

}*/
 /*
if(yc-5 < y[0] && yc+5 > y[0]){
	Commutatore.wichY[Commutatore.count]=0;
	for(int i=0;i<9;i++) {
		if(xc-5 < x[i] && xc+5 > x[i] ) {

	Commutatore.draw[Commutatore.count]=i;
			Commutatore.ciD=true;
			
			break;
      	}  
    }
	Commutatore.count++;
}

if(yc-5 < y[1] && yc+5 > y[1]){
	Commutatore.wichY[Commutatore.count]=1;
	for(int i=9;i<17;i++) {
		if(xc-5 < x[i] && xc+5 > x[i] ) {

	Commutatore.draw[Commutatore.count]=i;
			Commutatore.ciD=true;
			
			break;
      	}  
    }
	Commutatore.count++;
}


if(yc-5 < y[2] && yc+5 > y[2]){
	Commutatore.wichY[Commutatore.count]=2;
	for(int i=17;i<26;i++) {
		if(xc-5 < x[i] && xc+5 > x[i] ) {

	Commutatore.draw[Commutatore.count]=i;
			Commutatore.ciD=true;
			
			break;
      	}  
    }
	Commutatore.count++;
}

if(Commutatore.count==2){
	
	
	
	Main.enigma.c1[0]=alf1[Commutatore.draw[0]];
	Main.enigma.c2[0]=alf1[Commutatore.draw[1]];
	System.out.println("ok1 " + Main.enigma.c1[0] + " "+ Main.enigma.c2[0]);
}
	
if(Commutatore.count==4){
	Main.enigma.c1[1]=alf1[Commutatore.draw[2]];
	Main.enigma.c2[1]=alf1[Commutatore.draw[3]];

}*/
//OK

//FORSE POTEVA ESSERE FATTO PIU MEGLIO ABBESTIA
