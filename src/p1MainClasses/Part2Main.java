package p1MainClasses;

import java.io.FileNotFoundException;

import solutions.P1P2;
import solutions.P3;
import solutions.P4;
import solutions.Part2Methodology;
import solutions.StrategiesTimeCollection;

public class Part2Main {

	private static int[] parms = {10, 50, 1000, 50000, 1000, 200};
	// min size, max size, size increment, number of trials per size/strategy
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException {
		if (args.length > 6)
			System.out.println("Unexpected number of parameters.");
		for (int i=0; i<args.length; i++)
			parms[i] = Integer.parseInt(args[i]); 
		
		// Parm1: n
		// Parm2: m
		// Parm3: initial size
		// Parm4: final size to consider
		// Parm5: incremental steps (size)
		// Parm6: trials per size
		Part2Methodology p2m = new Part2Methodology(parms[0], parms[1], parms[2], parms[3], parms[4], parms[5]); 
		
	
		p2m.addStrategy(new StrategiesTimeCollection(new P1P2("P1")));
		p2m.addStrategy(new StrategiesTimeCollection(new P1P2("P2")));
		p2m.addStrategy(new StrategiesTimeCollection(new P3("P3")));
		p2m.addStrategy(new StrategiesTimeCollection(new P4("P4")));
		p2m.run();    // run the experiments on all the strategies added to the controller object (p2m)
		
		// save the results for each strategy....
		try {
			p2m.saveResults();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}