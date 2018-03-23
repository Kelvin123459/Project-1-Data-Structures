//Kelvin Garcia Muñiz
//802142644
//CIIC4020 - 030
package setIntersectionFinders;

import interfaces.IntersectionFinder;

public abstract class AbstractIntersectionFinder<E> implements IntersectionFinder<E> {
	private String name;   // to identify the strategy
	public AbstractIntersectionFinder(String name) {
		this.name = name; 
	}

	public String getName() { 
		return name; 
	}
}
