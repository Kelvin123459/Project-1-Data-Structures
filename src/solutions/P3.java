package solutions;

import java.io.File;
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

	@Override
	public MySet intersectSets(MySet[] t) {
		Scanner sc = new Scanner(new File("inputFiles", "parameters.txt"));
		int n= sc.nextInt();
		int m= sc.nextInt();
		MySet<E> t = new Set2();  // sets in P3's solution are of type Set2
		
		allElements.sort(null); 		
		E e = allElements.get(0); 
		Integer c = 1;
		for (int i=1; i < allElements.size(); i++) {
		    if (allElements.get(i).equals(e)) 
		       c++;
		    else { 
		       if (c == m) 
		          t.add(e);    // m is as in the previous discussion
		       e = allElements.get(i); 
		       c = 1; 
		    } 
		}
		if (c == m)
		    t.add(allElements.get(allElements.size()-1));
		return t;
	}
	private static List arrayToList(){
		
	}
}
