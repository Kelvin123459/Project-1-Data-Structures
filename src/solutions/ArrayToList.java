package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dataGenerator.DataReader;
import interfaces.MySet;

public class ArrayToList<E> {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<E> arrayToList(MySet[] t){
		ArrayList list = new ArrayList<E>();
		for(int i=0;i<t.length;i++){
			for(Object e: t[i]){
				list.add(e);
			}
		}
		return list;
	}
	
}
