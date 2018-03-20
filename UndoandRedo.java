import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

//this class enables undo and redo
public class UndoandRedo {
	static ArrayList<DollyPoints> dollyPoints;
	static Stack<ArrayList<DollyPoints>> undoList = new Stack<>();
	
	//undo stack stores the all the indices of the starting points
	static Stack<Integer> undoStack = new Stack<Integer>();
	NewPanel panel;
	public UndoandRedo(ArrayList<DollyPoints> dollyPoints, NewPanel panel) {
		this.dollyPoints = dollyPoints;
		this.panel = panel;
	}
	
	public void undo() {
		if(dollyPoints.isEmpty() || undoStack.empty())
			return;
		
		//removes all the points until the starting points of the stroke
		int removeIndex = undoStack.pop();
		removeSublist(dollyPoints.size()-1, removeIndex);

	}
	
	public void removeSublist(int startIndex, int endIndex) {
		
		// stores the last stroke into the the stack of arraylist
		ArrayList<DollyPoints> sublist = new ArrayList<DollyPoints>(dollyPoints.subList(endIndex, startIndex+1));
		undoList.push(sublist);
		for (int i = startIndex; i >= endIndex; --i) {
			dollyPoints.remove(i);
		}
	}
	
	//redos by transfering points from the undoList back to the Points arraylist so that it can be drawn again
	public void redo() {
		if(undoList.empty())
			return;
		undoStack.push(dollyPoints.size());
		dollyPoints.addAll(undoList.pop());
	}
	
	//clears the undo list
	public static void clear() {
		while(!undoList.empty()) {
			undoList.pop();
		}
	}
}
