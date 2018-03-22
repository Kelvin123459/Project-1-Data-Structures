package solutions;

import interfaces.MySet;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P1P2<E> extends AbstractIntersectionFinder<E>{
	
	public P1P2(String name) {
		super(name);
		
	}
	/*
	 * (non-Javadoc)
	 * @see interfaces.IntersectionFinder#intersectSets(interfaces.MySet[])
	 * Method implemented by P1 and P2
	 * @param t array containing the family of sets to be intersected. 
	 * @return the final intersection set (the result of intersecting all sets in t) 
	 *  for each element that belongs to t0, if it does not belong to t, remove from set t0.
	 * 	Try/Catch used to accept the CloneNotSupportedException without modifying the interface.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public MySet<E> intersectSets(MySet<E>[] t){
		MySet<E> t0;
		try {
			t0 = (MySet<E>) t[0].clone();
			for(int j=1;j<t.length;j++){
				for(E e: t[0]){ //for each element that belongs to t[0]
					if(!t[j].contains(e)){ //if t[j] does not contain e
						t0.remove(e); //remove element from t0;
					}
				}
			}
			return t0;  //returns set t1 (representing T)
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null; //if it cannot be cloned then return null
	}
}
