import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class IntSet {

	private Vector els;
	
	public IntSet() {
		els = new Vector();
	}
	
	public void insert(int x) {
		els.add(x);	
	}
	
	public void remove(int x) {
		els.remove(x);
	}
	
	public int size() {
		return els.size();
	}
	
	public Iterator elements() {
		ArrayList al = new ArrayList();
		Vector copy = (Vector)els.clone();
		Vector nums = new Vector();

		while(copy.size() > 0) {
			if(!nums.contains(copy.get(0))) {
				al.add(copy.get(0));
				nums.add(copy.get(0));
				copy.remove(0);
			}
		}
		Iterator it = al.iterator();
		return it;
	}
	
	
	public boolean repOk() {
		return true;
	}
	
	private int getIndex(Integer x) {		
		return els.indexOf(x);
	}
	
	public boolean isIn (int x) {
		return getIndex(new Integer(x)) >= 0;
	}

	public boolean subset(IntSet s) {
		if (s==null) {
			return false;
		}
		for (int i = 0; i <els.size(); i++) {
			if (!s.isIn(((Integer) els.get(i)).intValue())) {
				return false;
			}
		}
		return true;
	}
}
