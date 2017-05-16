import java.util.*;
public class Location implements Comparable<Location>{
    private int row,col;
    private int distToStart;
    private int distToGoal;
    private Location previous;
    private boolean aStar;
    public Location(int r,int c, Location prev, int start, int goal, boolean a){
	row = r;
	col = c;
	previous = prev;
	distToStart = start;
	distToGoal = goal;
	aStar = a;
    }
    public int getr(){
	return row;
    } 
    public int getc(){
	return col;
    }
    public int getg(){
	return distToGoal;
    }
    public int gets(){
	return distToStart;
    }
    public Location prev(){
	return previous;
    }
    public boolean geta(){
	return aStar;
    }
    public int compareTo(Location other){
	if(aStar){
	    Integer a = new Integer(distToGoal + distToStart);
	    Integer b = new Integer(other.getg() + other.gets());
	    return a.compareTo(b);
	}
	else{
	    Integer a = new Integer(distToGoal);
	    Integer b = new Integer(other.getg());
	    return a.compareTo(b);
	}
    }
}
