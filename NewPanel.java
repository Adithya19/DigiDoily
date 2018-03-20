import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

class NewPanel extends JPanel{
public static ArrayList<DollyPoints> dollyPoints = new ArrayList<>();
static Color color = Color.WHITE;
static boolean toggleSectors, reflect;
public static int div=1;
public static int size = 5;
public void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		Graphics2D g = (Graphics2D) gr;
		//draws the sectors everytime the paintcomponent is called
		Draw d = new Draw(g,div);
		d.sector();
		if(!dollyPoints.isEmpty()) {
			d.freedraw();
		}
		
	}
	

}
