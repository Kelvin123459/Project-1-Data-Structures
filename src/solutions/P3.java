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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public MySet intersectSets(MySet[] t) {
		MySet<E> t1 = new Set2();  // sets in P3's solution are of type Set2
		ArrayToList arrayToList = new ArrayToList();
		ArrayList<E> allElements= arrayToList.arrayToList(t);
		allElements.sort(null);		
		E e = allElements.get(0); 
		Integer c = 1;
		for (int i=1; i < allElements.size(); i++) {
		    if (allElements.get(i).equals(e)) 
		       c++;
		    else { 
		       if (c == 50) 
		          t1.add(e);    // m is as in the previous discussion
		       e = allElements.get(i); 
		       c = 1; 
		    } 
		}
		if (c == 50)
		    t1.add(allElements.get(allElements.size()-1));
		return t1;
	}
}
