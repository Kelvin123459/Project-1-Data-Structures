package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import interfaces.MySet;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

@SuppressWarnings("rawtypes")
public class P4<E> extends AbstractIntersectionFinder{
	public P4(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	ArrayToList arrayToList = new ArrayToList(); //see ArrayToList class.
	/*
	 * (non-Javadoc)
	 * @see interfaces.IntersectionFinder#intersectSets(interfaces.MySet[])
	 * Method intersectSets implemented by P3
	 * @param t array containing the family of sets to be intersected. 
	 * @return the final intersection set (the result of intersecting all sets in t) 
	 * If the count of an element is equal to m(50 in this scenario) then add to t1 (representing set T) 
	 * Implements HashMaps, unlike P3
	 */
	@SuppressWarnings("unchecked")
	@Override
	public MySet intersectSets(MySet[] t) {
		ArrayList<E> allElements= arrayToList.arrayToList(t); // Method converts array t to arrayList.
		HashMap<E, Integer> map = new HashMap<>(); 
		for (E e : allElements) { 
		     Integer c = map.getOrDefault(e, 0); 
		     map.put(e, c+1); 
		}
		MySet<E> t1 = new Set2<>(); 
		for (Map.Entry<E, Integer> entry : map.entrySet()){
			if (entry.getValue() == 50) 
		        t1.add(entry.getKey());	
		}
		return t1; //return t1 (representing T)
	}
}
