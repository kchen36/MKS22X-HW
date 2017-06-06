// work with Jeremy for 1 period and decided to try his way after my kept screwing up
import java.util.*;
public class MyDeque{
    public int front, end, size;
    public String[] ary;
    public MyDeque(){
	ary= new String[10];
	front = 1;
	end = -1;
	size = 0;
    }
    private void expand(){
	String[] array = new String[size * 2];
	for(int x = 0; x <= end; x++){
	    array[b] = ary[x];
	}
	if (front > end){
	    for(int y = 0; y <= ary.length - front - 1; y++){
		array[array.length - (y + 1)] = ary[ary.length - (y + 1)];
	    }
	}
	front = front + ary.length;
	ary = array;
    }
    public void addFirst(String a){
	if(a == null){
	    throw new NullPointerException();
	}
	if(size>=ary.length){
	    expand();
	}
	front-=1;
	if(front<0){
	    front=ary.length-1;
	}
	ary[front]=a;
	if(size==1){
	    end=front;
	}
	size++;
    }
    public void addLast(String a){
	if(a == null){
	    throw new NullPointerException();
	}
	if(size>=ary.length){
	    expand();
	}
	end+=1;
	if(end>=ary.length){
	    end=0;
	}
	ary[end]=a;
	if(size==1){
	    front=end;
	}
	size++;
    }
    public String removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    String ans = ary[front];
	    ary[front] = null;
	    front++;
	    size--;
	    if(front >= ary.length){
		front = 0;
	    }
	    if(size == 0){
		front = end;
	    }
	    return ans;
	}
    }
    public String removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    String ans = ary[end];
	    ary[end] = null;
	    end--;
	    size--;
	    if(end < 0){
		end = ary.length - 1;
	    }
	    if(size == 0){
	    end = front;
	    }
	    return ans;
	}
    }
    public String getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return ary[front];
    }
    public String getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return ary[end];
    }
}
