import java.util.ArrayList;

public class Erase {
	static boolean startErase;
	static ArrayList<DollyPoints> dollyPoints = new ArrayList<>();
	static ArrayList<DollyPoints> removeList = new ArrayList<>();
	
	public Erase(ArrayList<DollyPoints> dollyPoints) {
		this.dollyPoints = dollyPoints;
	}
	
	public void erase() {
		dollyPoints.removeAll(removeList);
		for (int i = 0; i < dollyPoints.size(); i++) {
			for (int j = 0; j < removeList.size(); j++) {
					if(dollyPoints.get(i).getX() == removeList.get(j).getX() && dollyPoints.get(i).getY() == removeList.get(j).getY())
						{dollyPoints.remove(i);
//						System.out.println(true);
						}
//					else
//						System.out.println(false);
			}
		}
		System.out.println("The points arraylist before erasing is " + dollyPoints);

	}
	
}
