//Kelvin Garcia Muñiz
//802142644
//CIIC4020 - 030
package p1MainClasses;

import java.io.FileNotFoundException;
import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import solutionsAndAidClasses.P1P2;
import solutionsAndAidClasses.P3;
import solutionsAndAidClasses.P4;
import solutionsAndAidClasses.UnionFinder;
/**
 * Main class for Part 1
 * @author Kelvin Garcia
 *
 * @param <E>
 */
public class Part1Main<E>{
	/**
	 * Main method for Part1.
	 * @param args
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws FileNotFoundException {
		UnionFinder uf = new UnionFinder(); //to initialize the sets
		DataReader reader = new DataReader(); //to initialize the data
		Object[][][] data =  reader.readDataFiles(); //data initialization
		args = new String[1];
		args[0] = null;
		P1P2 intersecter = new P1P2("P1"); //to call intersectSets P1
		P1P2 p2intersecter = new P1P2("P2"); //to call intersects P2
		P3 p3Intersecter = new P3("P3"); // to call intersectSets P3
		P4 p4Intersecter = new P4("P4"); //to call intersectSets P4
		MySet[] s1 = uf.unionWriter(data, "P1"); //intializes s1 to type Set1
		MySet[] s2 = uf.unionWriter(data, "P2"); //intializes s2 to type Set2
		MySet[] s3 = uf.unionWriter(data, "P3"); //intializes s3 to type Set2
		MySet[] s4 = uf.unionWriter(data, "P4"); //intializes s4 to type Set2
		
		Set1<Object> p1 = (Set1<Object>) intersecter.intersectSets(s1); //initializes p1 to the intersection of sets using strategy P1
		System.out.println("Solution P1: \n"+p1.toString()); //prints p1
		Set2<Object> p2 = (Set2<Object>) p2intersecter.intersectSets(s2); //initializes p2 to the intersection of sets using strategy P2
		System.out.println("Solution P2: \n"+p2.toString()); //prints p2
		Set2<Object> p3 = (Set2<Object>) p3Intersecter.intersectSets(s3); //initializes p3 to the intersection of sets using strategy P3
		System.out.println("Solution P3: \n"+p3.toString()); //prints p3
		Set2<Object> p4 = (Set2<Object>) p4Intersecter.intersectSets(s4);  //initializes p4 to the intersection of sets using strategy P4
		System.out.println("Solution P4: \n"+p4.toString()); //prints p4
	}			
}
