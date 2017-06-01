import java.util.*;
public class MyDeque{
    public int front, end;
    public String[] ary;
    public MyDeque(){
	ary = new String[10];
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
	end = ary.length-1;
	ary = array;
    }
    public void addFirst(String a){
	if(a == null){
	    throw new NullPointerException();
	}
	else if(front == end){
	    ary[0] = a;
	    front = ary.length - 1;
	}
    }
}
