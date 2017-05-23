import java.util.*;
public class FrontierQueue implements Frontier{
    public int front, end , size;
    public Location[] ary;
    public FrontierQueue(){
	ary = new Location[10];
	front = 0;
	end = 0;
	size = 0;
    }
    public int getSize(){
	return size;
    }
    private void expand(){
	Location[] array = new Location[ary.length*2];
	for(int x = front; x < ary.length;x ++){
	    array[x-front] = ary[x];
	}
	int x;
	for(x = 0;x <front; x ++){
	    array[front + x] = ary[x];
	}
	front = 0;
	end = ary.length-1;
	ary = array;
    }

    public void add(Location a){
	if(a == null){
	    throw new NullPointerException();
	}
	else if(ary[0] == null){
	    ary[0] = a;
	}
	else if(end == ary.length){
	    if(front != 0){
		end = 0;
		ary[end] = a;
	    }
	    else{
		expand();
		add(a);
	    }
	}
	else{
	    if(end + 1 != front){
		end = end + 1;
		ary[end] = a;
	    }
	    else{
		expand();
		add(a);
	    }
	}
	size++;
    }
    public Location next(){
	if(front == end){
	    throw new NoSuchElementException();
	}
	else{
	    Location a = ary[front];
	    ary[front] = null;
	    front = front + 1;
	    size--;
	    return a;
	}
    }
}
