import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Draw {
	public static BufferedImage image;
	Graphics2D g;
	Graphics2D imageGraphics;
	int div;
	double angle;
	public Draw(Graphics2D g, int div) {
		this.g = g;
		this.div = div;
		angle = 360/div;
	}
	
	//this method facilitates freehand drawing
	public void freedraw() {
		Graphics2D g2d = (Graphics2D) g.create();
		AffineTransform old = g.getTransform();	
		
		//the outer for loops rotates each point according to the number of divisions.
        for (int j = 0; j < NewPanel.dollyPoints.size(); j++) 
        	 {
        		//the inner for loop paints each point onto the buffered image
        		for (int i = 0; i < div; i++) {
	        		if(NewPanel.reflect)
	        			reflect(NewPanel.dollyPoints.get(j));
	        		
	        		imageGraphics.setColor(NewPanel.dollyPoints.get(j).getColor());
	        		imageGraphics.fillOval((int)NewPanel.dollyPoints.get(j).getX(), (int)NewPanel.dollyPoints.get(j).getY(), NewPanel.dollyPoints.get(j).getSize(), NewPanel.dollyPoints.get(j).getSize());
	        		imageGraphics.rotate(Math.toRadians(angle), 300, 300);
        		}
        	
		}
        
        //to prevent drawing over the sector lines
        if(NewPanel.toggleSectors) {
    		drawSectors(Color.black);
    		drawSectors(Color.white);
        }
		
		//hooking up the image to the panel
        g2d.drawImage(image, 0, 0, 600, 600, null);
        g2d.dispose();
        g.setTransform(old);
	}
	
	
	//this method displays the sector lines at the start of the programme
	public void sector() {
		image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
		imageGraphics = (Graphics2D)image.getGraphics();
		angle = 360.0/div;
		Graphics2D g2d = (Graphics2D) g.create();
        AffineTransform old = g.getTransform();	
        
        if(NewPanel.toggleSectors)
        	drawSectors(Color.WHITE);
        
        g2d.drawImage(image, 0, 0, 600, 600, null);
        g2d.dispose();
        g.setTransform(old);
	}
	
	// this method enables the reflection of each point by inverting the x and the y coordinates
	public void reflect(DollyPoints dollyPoint) {
			imageGraphics.setColor(dollyPoint.getColor());
			imageGraphics.fillOval((int)dollyPoint.getY(), (int)dollyPoint.getX(), dollyPoint.getSize(), dollyPoint.getSize());
	}
	
	//this method does the actual drawing of the sector lines
	public void drawSectors(Color color) {
		Graphics2D g = (Graphics2D)imageGraphics.create();
        for(int i =0; i < div; i++) {
        	g.setColor(color);
        	g.rotate(Math.toRadians(angle),300,300);
        	g.drawLine(0, 0, 300, 300);
        }
	}
	

}
