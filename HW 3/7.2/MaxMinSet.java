import java.util.Iterator;

//abstraction function
//AF_MaxMinSet(c) = AF_MaxIntSet(c)


public class MaxMinSet extends MaxIntSet {

	public MaxMinSet() {
		super();
	}
	
	public int min() throws EmptyException {
		if (super.size() == 0) {
			throw new EmptyException("hi");
		}
		
		int min = 99999999;
		Iterator it = super.elements();
		while(it.hasNext()) {
			if ((int)it.next() < min) {
				min = (int)it.next();
			}
		}
		return min;
	}
	
	public boolean repOk() {
		return true;
	}
}
