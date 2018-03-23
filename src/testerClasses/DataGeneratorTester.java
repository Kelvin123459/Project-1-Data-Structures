//Kelvin Garcia Muñiz
//802142644
//CIIC4020 - 030
package testerClasses;

import dataGenerator.DataGenerator;

public class DataGeneratorTester {

	public static void main(String[] args) {
		int totalSize = 2000; 
		int n = 20, m = 10; 
		DataGenerator dg = new DataGenerator(n, m, totalSize);
		dg.generateData(); 
		dg.printSizes();
		dg.printSets();
	}

}
