package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import interfaces.MySet;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public MySet intersectSets(MySet[] t) {
		MySet<E> t1 = new Set2();  // sets in P3's solution are of type Set2
		ArrayToList arrayToList = new ArrayToList(); //see ArrayToList class. Method converts array to arrayList.
		ArrayList<E> allElements= arrayToList.arrayToList(t); //set everyElement of t into allElements list.
		allElements.sort(null);	
		E e = allElements.get(0); 
		Integer c = 1;
		for (int i=1; i < allElements.size(); i++) {
		    if (allElements.get(i).equals(e)) 
		       c++;
		    else { 
		       if (c == 50)  // m is as in the previous discussion. 50 used to avoid FileNotFoundException
		          t1.add(e);  //if element count equals m, then add to t1.  
		       e = allElements.get(i); 
		       c = 1; 
		    } 
		}
		if (c == 50)
		    t1.add(allElements.get(allElements.size()-1));
		return t1; //returns set t1 (representing T)
	}
}
