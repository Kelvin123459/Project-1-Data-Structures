//Kelvin Garcia Muñiz
//802142644
//CIIC4020 - 030
package solutionsAndAidClasses;

import java.util.ArrayList;
import interfaces.MySet;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

@SuppressWarnings("rawtypes")
public class P3<E> extends AbstractIntersectionFinder{
	public P3(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	/*
	 * (non-Javadoc)
	 * @see interfaces.IntersectionFinder#intersectSets(interfaces.MySet[])
	 * Method intersectSets implemented by P3
	 * @param t array containing the family of sets to be intersected. 
	 * @return the final intersection set (the result of intersecting all sets in t) 
	 * If the count of an element is equal to m(50 in this scenario) then add to t1 (representing set T) 
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public MySet intersectSets(MySet[] t) {
		MySet<E> t1 = new Set2();  // sets in P3's solution are of type Set2
		UnionFinder uf = new UnionFinder();
		ArrayList<E> allElements= uf.arrayToList(t); //set everyElement of t into allElements list.
		allElements.sort(null);	//sort allElements to the elements natural order, hence null is taken as parameter
		E e = allElements.get(0); 
		Integer c = 1;
		for (int i=1; i < allElements.size(); i++) {
		    if (allElements.get(i).equals(e)) 
		       c++;
		    else { 
		       if (c == t.length)  // m is as in the previous discussion.
		          t1.add(e);  //if element count equals m, then add to t1.  
		       e = allElements.get(i); 
		       c = 1; 
		    } 
		}
		if (c == t.length)
		    t1.add(allElements.get(allElements.size()-1));
		return t1; //returns set t1 (representing T)
	}
}
