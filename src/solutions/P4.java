package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import interfaces.MySet;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P4<E> extends AbstractIntersectionFinder{
	public P4(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MySet intersectSets(MySet[] t) {
		ArrayToList arrayToList = new ArrayToList();
		ArrayList<E> allElements= arrayToList.arrayToList(t);
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
		return t1;
	}
}
