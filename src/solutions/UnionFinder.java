package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

public class UnionFinder <E>{
	/*
	 * (non-Javadoc)
	 * Method unionWriter implemented by all solutions
	 * @param 
	 * @return the final union set (the result of the union of all sets) 
	 *  
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MySet[] unionWriter(Object[][][] data, String s, int paramN,int paramM) throws FileNotFoundException{
		MySet[] t = new MySet[paramM];
		for(int j = 0 ; j<paramM; j++ ) {
			if(s.equals("P1")){
				t[j] = new Set1<E>();
			}
			else{
				t[j] = new Set2<E>();
			}
			for(int i=0; i<paramN; i++) {
				for(int k = 0 ; k < data[i][j].length; k++) {
					t[j].add(data[i][j][k]); 
				}
			}
		}
		return t; //return union set
	}
}
		