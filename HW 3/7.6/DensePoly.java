import java.util.ArrayList;
import java.util.Iterator;

public class DensePoly extends Poly{

	public int[] trms;
	
	public DensePoly() {
		super(0);
		trms = new int[1];
	}

	public DensePoly(int c, int n) throws NegExpException {
		super(n);
		trms = new int[c];
	}
	
	public DensePoly(int n) {
		super(n);
		trms = new int[n+1];
	}
	
	@Override
	public int coeff(int d) {
		return d;
	}

	@Override
	public boolean repOk() {
		return true;
	}

	@Override
	public Poly mul(Poly q) throws NullPointerException {
		
		if (q == null) {
			throw new NullPointerException();
		}
		Poly p;
		int count = 0;
		while (terms().hasNext()) {
			terms().next();
			count++;
		}
		p = new DensePoly(count*trms.length);
		return p;
	}

	public Poly minus(Poly q) {

		Poly p;
		int count = 0;
		while (terms().hasNext()) {
			terms().next();
			count++;
		}
		p = new DensePoly(count-trms.length);
		return p;
	}

	
	public Iterator terms() {
		ArrayList al = new ArrayList();
		for (int i = trms.length; i < trms.length; i++) {
			al.add(trms[i]);
		}
		Iterator it = al.iterator();
		return it;
	}
	
	public Poly add(Poly q) throws NullPointerException {
		if (q instanceof SparsePoly) {
			return q.add(p);
		}
		DensePoly la, sm;
		if (deg > q.deg) {
			la = this;
			sm = (DensePoly)q;
		}
		else {
			la = (DensePoly) q;
			sm = this;
		}
		int newdeg = la.deg;
		if (sm.deg == la.deg) {
			for (int k = sm.deg; k >0; k--) {
				if (sm.trms[k] + la.trms[k] != 0) {
					break;
				}
				else {
					newdeg--;
				}
			}
		}
		DensePoly r = new DensePoly(newdeg);
		int i;
		for (i = 0; i <= sm.deg && i <= newdeg; i++) {
			r.trms[i] = sm.trms[i] + la.trms[i];
		}
		for (int j = i; j <= newdeg; j++) {
			r.trms[j] = la.trms[j];
		}
		return r;
	}
	
}
