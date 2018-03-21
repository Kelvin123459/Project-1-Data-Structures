package solutions;

import java.util.ArrayList;

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
