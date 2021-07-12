import java.util.Iterator;

public abstract class IntList {

	public abstract Object first() throws EmptyException;
	public abstract IntList rest() throws EmptyException;
	public abstract Iterator elements();
	public abstract IntList addE1(Object x);
	public abstract int size();
	public abstract boolean repOk();
	
	public String toString() {
		
		String returnString = ""; 
		Iterator elems = elements();
		
		while (elems.hasNext()) {
			returnString += elems.next();
		}
	
		return returnString;
	}
	
	public boolean equals(Object o) {
		try { return equals ((IntList) o);}
		catch (ClassCastException e) { return false;}
	}
	
	public boolean equals(IntList o) {
		
		
		try {
			if ((o.first().equals(first())) && (o.rest().equals(rest()))) {
				return true;
			}
		} catch (EmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
	
	
	
}
