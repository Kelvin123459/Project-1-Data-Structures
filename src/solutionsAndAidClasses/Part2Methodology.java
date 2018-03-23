package solutionsAndAidClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.AbstractMap;
import java.util.ArrayList;

import dataGenerator.DataGenerator;
import solutionsAndAidClasses.StrategiesTimeCollection;

public class Part2Methodology<E>{
	private int initialSize;           // initial size to be tested
	private int repetitions;    // experimental repetitions per size
	private int incrementalSize;   	   // change of size
	private int fSize;                 // last size to be tested
	private static int paramN; 		   // parameter n
	private static int paramM;		   // parameter m
	private ArrayList<StrategiesTimeCollection<E>> resultsPerStrategy; 
	
	//Part2Methodology constructor
	public Part2Methodology(int n, int m, int is, int fs, int iss, int rps) { 
		paramN = n;
		paramM = m;
		initialSize = is; 
		repetitions = rps; 
		incrementalSize = iss; 
		fSize = fs; 
		resultsPerStrategy = new ArrayList<>(); 
	}
	public void addStrategy(StrategiesTimeCollection<E> strategy) { //adds the strategy to run
		resultsPerStrategy.add(strategy); 
	}
	public void run() throws CloneNotSupportedException, FileNotFoundException { 
		if (resultsPerStrategy.isEmpty())
			throw new IllegalStateException("No strategy has been added."); 
		for (int size=initialSize; size<=fSize; size+=incrementalSize) { 
			// For each strategy, reset the corresponding variable that will be used
			// to store the sum of times that the particular strategy exhibits for
			// the current size size
			for (StrategiesTimeCollection<E> strategy : resultsPerStrategy){ 
				strategy.resetSum();  //reset the variable that will be used
			}
			for (int r = 0; r<repetitions; r++) {
				Object[][][] data = generateData(size);  //data to be used by all data sets with the current size
				for (StrategiesTimeCollection<E> strategy : resultsPerStrategy) {  //Apply each strategy using the prev dataset and estimate the time
					long startTime = System.nanoTime(); // time before run
					strategy.runTrial((Integer[][][])data.clone());   // run the strategy
					long endTime = System.nanoTime(); // time after run
					strategy.incSum((int) (endTime-startTime));    
				}
			}
			for (StrategiesTimeCollection<E> strategy : resultsPerStrategy) { 
				strategy.add(new AbstractMap.SimpleEntry<Integer, Float>
				(size, (strategy.getSum()/((float) repetitions)))); 
			}
			System.out.println(size); //print the current size
		}
	}
	private Object[][][] generateData(int size) { //generate the data to be used
		DataGenerator dg = new DataGenerator(paramN, paramM, size);
		Object[][][] data = dg.generateData();  

		return data;
	}
	public void saveResults() throws FileNotFoundException { //save results to file
		PrintStream out = new PrintStream(new File("part2Results", "allResults.txt")); //print results in file allResults, folder part2Results
		out.print("Size");
		for (StrategiesTimeCollection<E> trc : resultsPerStrategy) 
			out.print("\t" + trc.getStrategyName()); 
		out.println();

		int numberOfSolutions = resultsPerStrategy.get(0).size(); 
		for (int i=0; i<numberOfSolutions; i++) {
			out.print(resultsPerStrategy.get(0).get(i).getKey());
			for (StrategiesTimeCollection<E> trc : resultsPerStrategy)
				out.print("\t" + trc.get(i).getValue());
			out.println(); 
		}	
		out.close(); //close PrintStream
	}
}