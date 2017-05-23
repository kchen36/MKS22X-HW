import java.util.*;
public class FrontierStack implements Frontier{
    private int size; 
    private Stack<Location> a ;
    public FrontierStack(){
	a = new Stack<Location>();
	size = 0;
    }
    public void add(Location l){
	a.push(l);
	size ++;
    }
    public Location  next(){
	size --;
	return a.pop();
    }
    public int getSize(){
	return size;
    }
}
