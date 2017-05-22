import java.util.*;
public class FrontierStack implements Frontier{
    private int size; 
    private Stack a ;
    public FrontierStack(){
	a = new Stack<Location>();
	size = 0;
    }
    public boolean hasNext(){
	return !empty();
    }
    public void add(Location l){
	a.push(l);
	size ++;
    }
    public Location  next(){
	size --;
	return a.pop();
    }
}
