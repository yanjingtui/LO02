package Game;
import java.util.*;
import Cards.*;
public class Pile {
private LinkedList<Tricks> tricks;
private LinkedList<Tricks> tricksOpen;

public enum Trick {
	one("The Hungry Rabbit", 5),
	two("The bunch of carrots", 1),
	three("The other hat trick", 6);
	private final int points;
	private final String name;
	public String getName() {
		return this.name;
				
	}
	public int getPoints() {
		return this.points;
	}
	private Trick(String name,int points) {
		this.points = points;
		this.name = name;
	}
	 public String toString() {
	     return (this.name);	
	    }
}
public Pile() {
	this.tricks = new LinkedList<Tricks>();
	for(Trick t : Trick.values()) {
		System.out.println(t.getName());
		System.out.println(t.getPoints());
		Tricks tr = new Tricks(t.getName(), t.getPoints());
		this.tricks.add(tr);

	}
}
private static Pile p = null;

public static synchronized Pile getInstance() {
	 if (p == null)
     {   p = new Pile(); 
     }
     return p;
 }


public void melanger() {
	Collections.shuffle(this.tricks);
}

public void openNext() {
	this.tricksOpen.add(this.tricks.getFirst());
	this.tricks.pop();
}
public Tricks getCurrentTrick() {
	return this.tricksOpen.getLast();
}
public static void main(String[] args) {
	Pile p = new Pile();
	System.out.println(p.tricks);
}
}
