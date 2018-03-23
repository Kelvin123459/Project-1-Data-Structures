package p1MainClasses;

import java.io.FileNotFoundException;

import solutionsAndAidClasses.P1P2;
import solutionsAndAidClasses.P3;
import solutionsAndAidClasses.P4;
import solutionsAndAidClasses.Part2Methodology;
import solutionsAndAidClasses.StrategiesTimeCollection;

public class Part2Main {

	private static int[] parms = {10, 50, 1000, 50000, 1000, 200};
	// min size, max size, size increment, number of trials per size/strategy
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException {
		if (args.length > 6) //if the number of parameters is greater than 6 print message on screen
			System.out.println("Unexpected number of parameters.");
		for (int i=0; i<args.length; i++) //set parameters 
			parms[i] = Integer.parseInt(args[i]); 		
		// Parm1: n
		// Parm2: m
		// Parm3: initial size
		// Parm4: final size
		// Parm5: increments to size
		// Parm6: repetitions per size
		Part2Methodology p2m = new Part2Methodology(parms[0], parms[1], parms[2], parms[3], parms[4], parms[5]);  
		//create instance of Part2Methodology
		p2m.addStrategy(new StrategiesTimeCollection(new P1P2("P1"))); //add strategy P1
		p2m.addStrategy(new StrategiesTimeCollection(new P1P2("P2"))); //add strategy P2
		p2m.addStrategy(new StrategiesTimeCollection(new P3("P3"))); //add strategy P3
		p2m.addStrategy(new StrategiesTimeCollection(new P4("P4"))); //add strategy P4
		p2m.run();    // run the all strategies added to p2m
		//Save the results for each strategy
		try {
			p2m.saveResults();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}