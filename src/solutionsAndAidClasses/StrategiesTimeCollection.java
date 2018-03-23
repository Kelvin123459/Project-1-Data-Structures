//Kelvin Garcia Muñiz
//802142644
//CIIC4020 - 030
package solutionsAndAidClasses;

import interfaces.IntersectionFinder;
import interfaces.MySet;
import java.util.ArrayList;
import java.util.Map;
/**
 * Contains the needed method to aid in the collection of time data
 * @author Kelvin Garcia
 *
 * @param <E>
 */
@SuppressWarnings("serial")
public class StrategiesTimeCollection<E> extends ArrayList<Map.Entry<Integer, Float>> { 
	public UnionFinder<E> uf = new UnionFinder<E>(); //to be used by the runTrial method
    private IntersectionFinder<E> strategy;    // Each strategy provided by P1, P2, P3, P4
    private float sum;    
    public StrategiesTimeCollection(IntersectionFinder<E> strategy) { 
        this.strategy = strategy; 
    } 
    public String getStrategyName() { 
        return strategy.getName(); 
    }
    /**
     * 
     * @param data corresponds to the data used to run the strategies
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void runTrial(Object[][][] data){
    		//initializes the set with the defined data and strategy (P1, P2, P3, P4)
    		MySet[] set = uf.unionWriter(data, this.getStrategyName()); 
    		strategy.intersectSets(set); //runs the intersects method from the given class (given by the unionWriter)
    }
    public void resetSum() { 
    	sum = 0.0f; 
    }
    public void incSum(float t) { 
    	sum += t; 
    }
    public float getSum() { 
    	return sum; 
    }
}
