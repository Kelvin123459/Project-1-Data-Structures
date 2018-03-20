package solutions;

import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P1P2<E> extends AbstractIntersectionFinder<E>{
	
	public P1P2(String name) {
		super(name);
		
	}
	
	@Override
	public MySet<E> intersectSets(MySet<E>[] t){
		MySet<E> t0;
		try {
			t0 = (MySet<E>) t[0].clone();
			for(int j=1;j<t.length;j++){
				for(E e: t[0]){
					if(!t[j].contains(e)){
						t0.remove(e);
					}
				}
			}
			return t0;
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}
