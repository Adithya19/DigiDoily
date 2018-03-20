import java.awt.*;

//this class inherits from the Point class giving it some additional functionality as well such as colours and size
public class DollyPoints extends Point{
	private Color color;
	private int size;
	public DollyPoints(int x, int y, Color color, int size) {
		super(x,y);
		this.color = color;
		this.size = size;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getSize() {
		return size;
	}
	
	public Color getColor() {
		return color;
	}
}
