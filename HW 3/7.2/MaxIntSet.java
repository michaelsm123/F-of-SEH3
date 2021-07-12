import java.util.Iterator;

public class MaxIntSet extends IntSet {

	private int biggest;
	
	public MaxIntSet() {
		super();
	}
	
	public void insert(int x) {
		if (size() == 0 || x > biggest) {
			biggest = x;
			super.insert(x);
		}
	}
	
	public void remove(int x) {
		super.remove(x);
		if (size() ==0 || x <biggest) return;
		Iterator g = elements();
		biggest =((Integer) g.next()).intValue();
		while (g.hasNext()) {
			int z = ((Integer) g.next()).intValue();
			if (z > biggest) {
				biggest = z;
			}
		}
	}
	
	public int max() throws EmptyException {
		if (size() == 0) {
			throw new EmptyException("MaxIntSet.max"); 
		}
		return biggest;
	}
	
	public boolean repOk() {
		if(!super.repOk()) {
			return false;
		}
		if (size() ==0) {
			return true;
		}
		boolean found = false;
		Iterator g = elements();
		while (g.hasNext()) {
			int z = ((Integer) g.next()).intValue();
			if (z > biggest) {
				return false;
			}
			if (z == biggest) {
				found = true;
			}
		}
		return found;
	}
}
