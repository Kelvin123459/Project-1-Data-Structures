package p1MainClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import solutions.P1P2;

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
		DataReader reader = new DataReader();
		Scanner parameters = new Scanner(new File("inputFiles", "parameters.txt")); 
		int n = parameters.nextInt(); 
		int m = parameters.nextInt();
		parameters.close();
		Set1[] s1 = new Set1[m];
		Set2[] s2 = new Set2[m];
		for(int i=0; i<s1.length&&i<s2.length;i++){
			s1[i] = new Set1<Integer>();
			s2[i] = new Set2<Integer>();
		}
		Set1<Object>[] dataUnion = (Set1[]) unionWriter(s1);
		System.out.println(dataUnion[0].toString());
		Set2<Object>[] dataUnion2 = (Set2[]) unionWriter(s2);
		System.out.println(dataUnion2[0].toString());

	}	
	
}
