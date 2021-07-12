import java.util.Iterator;

//abstraction function
//AF_IntListSub(c) = AF_IntList(c)


public abstract class IntListSub extends IntList  {


	public int largest() {
		
		int max = 0;
		Iterator elems = elements();
		
		while (elems.hasNext()) {
			int next = (int)elems.next();
			
			if (next > max) {
				max = (int)elems.next(); 
			}
		}
		return max;
	}

	public int smallest() {
		
		int min = 9999999;
		Iterator elems = elements();
		
		while (elems.hasNext()) {
			int next = (int)elems.next();
			
			if (next < min) {
				min = (int)elems.next(); 
			}
		}
		return min;
	}
	public boolean repOk() {

		return true;
	}

}
