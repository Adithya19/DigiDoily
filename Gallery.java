import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.awt.*;
//THIS CLASS IS PROBABLY NOT REQUIRED
public class Gallery extends JPanel{
	BufferedImage image;
	public Gallery(BufferedImage image) {
		this.image = image;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.black);
		Graphics2D g2d = (Graphics2D)g;
//		g2d.fillRect(0, 0, 10, 10);
		g.drawImage(image, 0, 0 , null);
	}
}
