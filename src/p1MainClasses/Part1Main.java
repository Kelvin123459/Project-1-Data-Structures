package p1MainClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import solutions.P1P2;
import solutions.P3;
import solutions.P4;
import solutions.UnionFinder;

public class Part1Main<E>{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws FileNotFoundException {
		UnionFinder uf = new UnionFinder();
		DataReader reader = new DataReader(); 
		Object[][][] data =  reader.readDataFiles();
		Scanner parameters = new Scanner(new File("inputFiles", "parameters.txt")); //find parameters.txt in folder inputFiles
		int n = parameters.nextInt(); //parameter n 
		int m = parameters.nextInt(); //parameter m
		parameters.close();
		P1P2 intersecter = new P1P2("P1P2"); //to call intersectSets P1P2
		P3 p3Intersecter = new P3("P3"); // to call intersectSets P3
		P4 p4Intersecter = new P4("P4"); //to call intersectSets P4
		MySet[] s1 = uf.unionWriter(data, "P1", n, m);
		MySet[] s2 = uf.unionWriter(data, "P2", n, m);
		MySet[] s3 = uf.unionWriter(data, "P3", n, m);
		MySet[] s4 = uf.unionWriter(data, "P4", n, m);

		
		Set1<Object> p1 = (Set1<Object>) intersecter.intersectSets(s1);
		System.out.println("Solution P1: \n"+p1.toString());
		Set2<Object> p2 = (Set2<Object>) intersecter.intersectSets(s2);
		System.out.println("Solution P2: \n"+p2.toString());
		Set2<Object> p3 = (Set2<Object>) p3Intersecter.intersectSets(s3);
		System.out.println("Solution P3: \n"+p3.toString());
		Set2<Object> p4 = (Set2<Object>) p4Intersecter.intersectSets(s4);
		System.out.println("Solution P4: \n"+p4.toString());

	}	
	
}
