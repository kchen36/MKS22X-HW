import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    private Location[] ary;
    private int constant, size;
    public FrontierPriorityQueue(){
	ary = new Location[10];
	size = 0;
	constant = -1;
    }
    private void resize(){
	Location[] ary2 = new Location[ary.length * 2];
	for(int x = 0; x < ary.length; x ++){
	    ary2[x] = ary[x];
	}
	ary = ary2;
    }
    public void add(Location s){
	if(size == ary.length) resize();
	ary[size + 1] = s;
	size ++;
	if(size > 1){
	    pushUp();
	}
    }
    public Location peek(){
	if(size == 0) throw new NoSuchElementException();
	return ary[1];
    }
    private void pushUp(){
	Location x = ary[size];
	for(int i = size; i > 1; i/=2){
	    if(ary[i/2].compareTo(ary[i]) * constant > 0){
		ary[i] = ary[i/2];
		ary[i/2] = x;
	    }
	}
    }
    public Location next(){
	if(size == 0) throw new NoSuchElementException();
	Location val = ary[1];
	ary[1] = ary[size];
	ary[size] = null;
	size --;
	pushDown();
	return val;
    } 
    private void pushDown(){
	int x = 1;
        while(x * 2 <= size){
	    Location val = ary[x];
	    Location bigger;
	    int dir;
	    if(x * 2 < size){
		if(ary[x * 2].compareTo(ary[x * 2 + 1]) * constant < 0){
		    bigger = ary[x * 2];
		    dir = 0;
		}
		else{
		    bigger = ary[x * 2 + 1];
		    dir = 1;
		}
		if(ary[x * 2 + dir].compareTo(ary[x]) * constant < 0){
		    ary[x] = ary[x * 2 + dir];
		    ary[x * 2 + dir] = val;
		    x = x * 2 + dir;
		}
		else break;
	    }
	    else if(x* 2 <= size && ary[x * 2].compareTo(ary[x]) * constant < 0){
		ary[x] = ary[x * 2];
		ary[x * 2] = val;
		x = x * 2;
	    }
	    else break;
	}
    }
    public int getSize(){
	return size;
    }
    public String toString(){
	String s = "";
	for(int x = 1; x<= size; x++){
	    s += ary[x] + " ";
	}
	return s;
    }
}
