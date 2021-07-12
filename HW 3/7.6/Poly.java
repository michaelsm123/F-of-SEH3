import java.util.Iterator;

public abstract class Poly {

	protected int deg;
	
	public Poly(int n) {
		deg = n;
	}
	
	public abstract int coeff(int d);
	public abstract boolean repOk();
	public abstract Poly add(Poly q);
	public abstract Poly mul(Poly q);
	public abstract Poly minus(Poly q);
	public abstract Iterator terms();
	
	public int degree() {
		return deg;
	}
	
	public boolean equals(Object o) {
		try {
			return equals((Poly) o);
		}
		catch (ClassCastException e) {
			return false;
		}
	}
	
	public boolean equals(Poly p) {
		if (p == null || deg != p.deg) {
			return false;
		}
		Iterator tg = terms();
		Iterator pg = p.terms();
		while (tg.hasNext()) {
			int tx = ((Integer) tg.next()).intValue();
			int px = ((Integer) pg.next()).intValue();
			if (tx != px || coeff(tx) != p.coeff(px)) {
				return false;
			}
		}
		return true;		
	}
	
	public Poly sub(Poly p) {
		return add(p.minues());
	}
	
	public String toString() {
		String out = "";
		
		while (terms().hasNext()) {
			out += terms().next();
		}
		return out;
	}
}
