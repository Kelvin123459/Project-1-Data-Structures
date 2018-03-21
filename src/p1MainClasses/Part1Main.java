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

public class Part1Main<E>{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static MySet[] unionWriter(MySet[] set) throws FileNotFoundException{
		DataReader reader = new DataReader();
		Scanner parameters = new Scanner(new File("inputFiles", "parameters.txt")); 
		int n = parameters.nextInt(); 
		int m = parameters.nextInt();
		parameters.close();
		Integer[][][] data = (Integer[][][]) reader.readDataFiles();
		for(int j = 0 ; j<m ; j++ ) {
			for(int i=0; i<n; i++) {
				for(int k = 0 ; k < data[i][j].length; k++) {
					set[j].add(data[i][j][k]);
				}
			}
		}
		return set;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws FileNotFoundException {
		P1P2 intersecter = new P1P2("P1P2");
		P3 p3Intersecter = new P3("P3");
		P4 p4Intersecter = new P4("P4");
		Scanner parameters = new Scanner(new File("inputFiles", "parameters.txt")); 
		int n = parameters.nextInt(); 
		int m = parameters.nextInt();
		parameters.close();
		Set1[] s1 = new Set1[m];
		Set2[] s2 = new Set2[m];
		Set2[] s3 = new Set2[m];
		Set2[] s4 = new Set2[m];
		for(int i=0; i<s1.length&&i<s2.length;i++){
			s1[i] = new Set1<Integer>();
			s2[i] = new Set2<Integer>();
			s3[i] = new Set2<Integer>();
			s4[i] = new Set2<Integer>();
		}
		Set1<Object>[] p1 = (Set1[]) unionWriter(s1);
		System.out.println("Solution P1: \n"+intersecter.intersectSets(p1).toString());
		Set2<Object>[] p2 = (Set2[]) unionWriter(s2);
		System.out.println("Solution P2: \n"+intersecter.intersectSets(p2).toString());
		Set2<Object>[] p3 = (Set2[]) unionWriter(s3);
		System.out.println("Solution P3: \n"+p3Intersecter.intersectSets(p3).toString());
		Set2<Object>[] p4 = (Set2[]) unionWriter(s4);
		System.out.println("Solution P4: \n"+p4Intersecter.intersectSets(p4).toString());

	}	
	
}
