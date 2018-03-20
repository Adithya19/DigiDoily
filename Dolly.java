import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.event.*;

public class Dolly extends JFrame {
		
		JLabel label = new JLabel("5");
		JLabel sectorLabel = new JLabel("1");
		ArrayList<ImageIcon> galleryList = new ArrayList();
		NewPanel panel = new NewPanel();
		public void start() {
			//creating the components
			panel = new NewPanel();
			JPanel mainpanel = new JPanel();
			this.setResizable(false);
			
			//setting up the panels before adding to the frame
			mainpanel.setLayout(new GridLayout(1,2));
			panel.setPreferredSize(new Dimension(600,600));
			panel.setBackground(Color.BLACK);
			
			//adding components to the doily panel
			panel.addMouseListener(new mousedraw(NewPanel.dollyPoints,panel));
			panel.addMouseMotionListener(new mousedraw(NewPanel.dollyPoints,panel));
			
			//creating the control panel and its components
			JPanel controlpanel = new JPanel();
			JButton undoButton = new JButton("Undo");
			JButton redoButton = new JButton("Redo");
			JButton clearButton = new JButton("Clear");
			JButton colorbutton = new JButton("Choose your colour");
			JButton saveButton = new JButton("Save");
			JButton remove = new JButton("Remove");
			BasicArrowButton uparrow = new BasicArrowButton(BasicArrowButton.NORTH);
			BasicArrowButton downarrow = new BasicArrowButton(BasicArrowButton.SOUTH);
			JButton pen = new JButton("Pen");
			JButton eraser = new JButton("Eraser");
			JCheckBox toggleSectors = new JCheckBox("Toggle Sectors");
			JCheckBox reflect = new JCheckBox("Reflect");
			JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 1);
			slider.setMajorTickSpacing(10);
			slider.setMinorTickSpacing(1);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			if(slider.getValue() == 0)
				slider.setValue(1);
			
			//creating the gallery
			JPanel galleryPanel = new JPanel();
			JScrollPane scroll = new JScrollPane(galleryPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);;
			galleryPanel.add(remove);
			
			//adding listeners to the buttons
			clearButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					NewPanel.dollyPoints.clear();
					repaint();
				}
				
			});
			colorbutton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-genrated method stub
					panel.color = Color.WHITE;
					panel.color = JColorChooser.showDialog(null, "pick your color", panel.color);
				}
			});
			
			
			uparrow.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 NewPanel.size++;
					label.setText("" + NewPanel.size);
				}
			});
			
			downarrow.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(NewPanel.size==1)
						return;
					// TODO Auto-generated method stub
					NewPanel.size--;
					label.setText("" + NewPanel.size);
				}
			});
			
			undoButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					UndoandRedo Undo = new UndoandRedo(NewPanel.dollyPoints, panel);
					Undo.undo();
					repaint();
				}
			});
			
			redoButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					UndoandRedo redo = new UndoandRedo(NewPanel.dollyPoints, panel);
					redo.redo();
					repaint();
				}
			});
			
			saveButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Save save = new Save(galleryPanel);
					save.addtoGallery(Draw.image);
					save.displayGallery();

				}
			});			
			
			remove.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Save save = new Save(galleryPanel);
					save.deleteimage();
					save.displayGallery();

				}
			});	
			
			eraser.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					Erase.startErase = true;
				}
				
			});
			
			pen.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Erase.startErase = false;
				}
				
			});
			
			slider.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent arg0) {
					// TODO Auto-generated method stub
					if(slider.getValue() == 0)
						return;
					NewPanel.div = slider.getValue();
					repaint();
					sectorLabel.setText("" + slider.getValue());
					
				}
				
			});
			
			toggleSectors.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					panel.toggleSectors = !panel.toggleSectors;
					panel.repaint();
				}
				
			});
			
			reflect.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					panel.reflect = !panel.reflect;
					panel.repaint();
				}
				
			});
			
			//creating the right panel
			//the right panel stores the control panel and the gallery panel
			JPanel rightPanel = new JPanel();
			rightPanel.setLayout(new GridLayout(2,1));
			rightPanel.add(controlpanel);
			rightPanel.add(scroll);
			
			//adding components to the control panel
			controlpanel.setLayout(new FlowLayout());
			controlpanel.add(clearButton);
			controlpanel.add(undoButton);
			controlpanel.add(redoButton);
			controlpanel.add(colorbutton);
			controlpanel.add(uparrow);
			controlpanel.add(label);
			controlpanel.add(downarrow);
			controlpanel.add(pen);
			controlpanel.add(eraser);
			controlpanel.add(saveButton);
			controlpanel.add(slider); 
			controlpanel.add(sectorLabel);
			controlpanel.add(remove);
			controlpanel.add(toggleSectors);
			controlpanel.add(reflect);

			mainpanel.add(panel);
			mainpanel.add(rightPanel);
			this.add(mainpanel);
			this.setSize(new Dimension(1200, 600));
			this.setVisible(true);
		}
		
		public static void main(String args[]) {
			Dolly d = new Dolly();
			d.start();
		}	
		

}
