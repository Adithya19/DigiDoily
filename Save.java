import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Save {
	JPanel galleryPanel = new JPanel();
	public boolean selected;
	
	public Save(JPanel panel) {
		galleryPanel = panel;
	}
	public static ArrayList<JButton> buttonList = new ArrayList<>();
	public void addtoGallery(BufferedImage image) {
		JButton newbutton = new JButton();
		BufferedImage scaledimage = scale(image, 100, 100);
		newbutton.setBackground(Color.BLACK);
		newbutton.setBorder(new LineBorder(Color.BLACK));
		newbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				selected = !selected;
				if(selected)
					newbutton.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
				else
					newbutton.setBorder(new LineBorder(Color.BLACK));
			}
		});
		newbutton.setIcon(new ImageIcon(scaledimage));
		buttonList.add(newbutton);
	}
	
	public void displayGallery() {
		clearGallery();
		for(JButton b: buttonList) {
			galleryPanel.add(b);
		}
	}
	
	private void clearGallery() {
		galleryPanel.removeAll();
		galleryPanel.revalidate();
		galleryPanel.repaint();
	}
	
	public BufferedImage scale(BufferedImage image, int width, int height) {
	    BufferedImage scaledimage = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    Graphics2D g = (Graphics2D) scaledimage.createGraphics();
	    g.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g.drawImage(image, 0, 0, width, height, null);
	    g.dispose();
	    return scaledimage;
	}
	
	public void deleteimage() {
		for (int i = 0; i < buttonList.size(); i++) {
			LineBorder lb = (LineBorder)(buttonList.get(i).getBorder());
			if(lb.getLineColor() == Color.RED)
				buttonList.remove(i);
		}
	}
}
