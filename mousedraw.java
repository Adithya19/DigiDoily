import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class mousedraw implements MouseMotionListener, MouseListener{
	
		ArrayList<DollyPoints> dollyPoints = new ArrayList<>();
		NewPanel panel;
		boolean start = true;
		
		public mousedraw(ArrayList<DollyPoints> dollyPoints, NewPanel panel) {
			this.dollyPoints = dollyPoints;
			this.panel = panel;
		}
		
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}
		
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			DollyPoints p = new DollyPoints(e.getX(),e.getY(), NewPanel.color, NewPanel.size);
			if(Erase.startErase) {
				p.setColor(Color.BLACK);
			}
			dollyPoints.add(p);
			panel.repaint();
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}   
			

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
						
		}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DollyPoints p = new DollyPoints(e.getX(),e.getY(), NewPanel.color, NewPanel.size);
				if(Erase.startErase) {
					p.setColor(Color.BLACK);
					panel.repaint();
				}
				else {
					dollyPoints.add(p);
				}
				
				//adding the strokes to the undo list
				UndoandRedo.undoStack.push(dollyPoints.indexOf(p));
				UndoandRedo.clear();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
		
		
}