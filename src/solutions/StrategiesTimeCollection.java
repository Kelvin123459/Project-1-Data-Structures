package solutions;

import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

@SuppressWarnings("serial")
public class StrategiesTimeCollection<E> extends ArrayList<Map.Entry<Integer, Float>> { 
	public UnionFinder<E> uf = new UnionFinder<E>();
	int m = this.m;
	int n = this.n;
    private IntersectionFinder<E> strategy;    // the strategy
    private float sum;   
    
    public StrategiesTimeCollection(IntersectionFinder<E> strategy) { 
        this.strategy = strategy; 
    } 
    
    public String getStrategyName() { 
        return strategy.getName(); 
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void runTrial(Object[][][] data) throws FileNotFoundException {
    		MySet[] set = uf.unionWriter(data, this.getStrategyName(), n, m);
    		strategy.intersectSets(set);
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
