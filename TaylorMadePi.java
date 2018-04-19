// Alan Vitullo

import java.applet.*;
import java.awt.*;
import java.awt.image.*;


public class TaylorMadePi extends Applet implements ImageObserver, Runnable {
	//
	Image img;
	//
	String filename = "Pie.jpg";

    public void init()
    {
    		//
    	if (filename != null) {
    		//
        img = getImage(getDocumentBase(),filename);
    		}

    }

    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {

			     if ((infoflags & ImageObserver.ALLBITS) != 0) {
			       showStatus("Image Complete");
			       this.repaint();
			       return false;
			     }
			     else {
			       showStatus("x: " + x + " y: " + y + " width: " + width
			        + " height: " + height);
			       this.repaint();
			     }
			     return true;
			  }

	public void paint(Graphics g) {
		//
		g.drawImage(img, 370, 80, this);
		//
		final long MAX_COUNT = 10;
		final double highRange = 4.0;
		final double lowRange = 3.0;
		//
		int width = 800;
		int height = 600;
		int xPos=0, xPosPrevious=0;
		int yPos=0, yPosPrevious=0;
		//
	    double base = 1.0;
	    double finalSum = 0.0;
	    double pi;
	    //
	    for (int i=0; i<width; i++) {
	        //
	        if (i%2 == 0) {
	        //
	        	finalSum += (1/base);
	        //
	        base += 2;
	        }
	        else {
	        //
	        	finalSum -= (1/base);
	        //
	        base += 2;
	        }
	        //
	        xPos=i;
	        System.out.println(xPos);
	        yPos=(int)((4.0-4*finalSum)/.0025);
	        System.out.println(yPos);
	        //
	        if(i!=0)
	        g.drawLine(xPosPrevious, yPosPrevious, xPos, yPos);
	        //
	        g.fillOval(xPos, yPos, 1, 1);
	        xPosPrevious = xPos;
	        yPosPrevious = yPos;
	        System.out.println(4*finalSum);
	    }
	    //
	    pi = 4 * finalSum;
	    //
	    g.setColor(Color.blue);
	    g.fillRect(370, 280, 200, 30);
	    //
	    g.setColor(Color.orange);
	    g.drawString("Pi: ", 375, 300);
		g.drawString(Double.toString(pi), 400, 300);

		/*
		//
		int j=0;
		//
		for(int i=0; i<300; i++) {
			g.drawArc(50,50,i,j,45,45);
			j+=2;
		}
		*/

		/*
		g.drawRoundRect(40, 50, 90, 90, 200, 200);
	    g.fillRoundRect(40, 160, 90, 90, 200, 200);
				                 // using drawOval()
	    g.drawOval(150, 50, 90, 90);
	    g.fillOval(150, 160, 90, 90);
				                // using drawArc()
	    g.drawArc(270, 50, 90, 90, 0, 360);
	    g.fillArc(270, 160, 90, 90, 0, 360);
	    */
	}

	public static void main(String[] args) {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
