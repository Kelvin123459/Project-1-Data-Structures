//Kelvin Garcia Muñiz
//802142644
//CIIC4020 - 030
package solutionsAndAidClasses;

import java.util.ArrayList;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

public class UnionFinder <E>{
	/*
	 * (non-Javadoc)
	 * Method unionWriter implemented by all solutions
	 * @param data containing a 3d array with the data to be used
	 * @param s containing a String with the desired strategy (P1, P2, P3, P4)
	 * @return the final union set (the result of the union of all sets) 
	 *  
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MySet[] unionWriter(Object[][][] data, String s){
		int m = data[0].length;
		int n = data.length;
		MySet[] t = new MySet[m];
		for(int j = 0 ; j<m; j++ ) {
			if(s.equals("P1")){
				t[j] = new Set1<E>();
			}
			else{
				t[j] = new Set2<E>();
			}
			for(int i=0; i<n; i++) {
				for(int k = 0 ; k < data[i][j].length; k++) {
					t[j].add(data[i][j][k]); 
				}
			}
		}
		return t; //return union set
	}
	/*
	 * (non-Javadoc)
	 * Method arrayToList implemented by P3 & P4 solutions
	 * @param t array containing the family of sets to be intersected
	 * @return list containing the family of sets to be intersected 
	 *  
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<E> arrayToList(MySet[] t){
		ArrayList list = new ArrayList<E>();
		for(int i=0;i<t.length;i++){
			for(Object e: t[i]){ //for each element of t[i]
				list.add(e); //add the element
			}
		}
		return list;
	}
}
		