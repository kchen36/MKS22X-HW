import java.util.*;
public class MyDeque{
    public int front, end, size;
    public String[] ary;
    public MyDeque(){
	ary = new String[10];
	size = 0;
	front = 0;
	end = 0;
    }
    private void expand(){
	String[] array = new String[ary.length*2];
	for(int x = front; x < ary.length;x ++){
	    array[x-front] = ary[x];
	}
	int x;
	for(x = 0;x <front; x ++){
	    array[front + x] = ary[x];
	}
	front = 0;
	end = ary.length - 1;
	ary = array;
    }
    public void addFirst(String a){
	if(a == null){
	    throw new NullPointerException();
	}
	else if(size == 0){
	    ary[0] = a;
	    front = ary.length - 1;
	    end = 1;
	}
	else if(front == end){
	    expand();
	    addFirst(a);
	}
	else{
	    ary[front] = a;
	    if(front == 0){
		front = ary.length - 1;
	    }
	    front --;
	}
	size ++;
    }
    public void addLast(String a){
	if(a == null){
	    throw new NullPointerException();
	}
	else if(size  == 0){
	    ary[0] = a;
	    front = ary.length - 1;
	    end = 1;
	}
	else if(front == end){
	    expand();
	    addLast(a);
	}
	else{
	    ary[end] = a;
	    if(end == ary.length - 1){
		end = 0;
	    }
	    end ++;
	}
	size ++;
    }
    public String removeLast(){
	if(front == end){
	    throw new NoSuchElementException();
	}
	else{
	    if(end == 0){
		end = ary.length - 1;
	    }
	    end = end - 1;
	    String a = ary[end];
	    ary[end] = null;
	    size --;
	    return a;
	}
    }
    public String removeFirst(){
	if(front == end){
	    throw new NoSuchElementException();
	}
	else{
	    if (front == ary.length - 1){
		front = 0;
	    }
	    front = front ++;
	    String a = ary[end];
	    ary[end] = null;
	    size --;
	    return a;
	}
    }
    public String getFirst(){
	if(front == end){
	    throw new NoSuchElementException();
	}
	else{
	    return ary[front - 1];
	}
    }
    public String getLast(){
	if(front == end){
	    throw new NoSuchElementException();
	}
	else{
	    return ary[end - 1];
	}
    }
}
