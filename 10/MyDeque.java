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
	else if(ary[0] == null){
	    ary[0] = a;
	}
	else if(front == 0){
	    if(end != ary.length){
		front = ary.length - 1;
		ary[front] = a;
	    }
	    else{
		expand();
		addFirst(a);
	    }
	}
	else{
	    if(front - 1 != end){
		front = front - 1;
		ary[front] = a;
	    }
	    else{
		expand();
		addFirst(a);
	    }
	}
    }
    public void addLast(String a){
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
		addLast(a);
	    }
	}
	else{
	    if(end + 1 != front){
		end = end + 1;
		ary[end] = a;
	    }
	    else{
		expand();
		addLast(a);
	    }
	}
    }
    public String removeFirst(){
	if(front == end){
	    throw new NoSuchElementException();
	}
	else{
	    String a = ary[front];
	    ary[front] = null;
	    front = front + 1;
	    return a;
	}
    }
    public String removeLast(){
	if(front == end){
	    throw new NoSuchElementException();
	}
	else{
	    String a = ary[end];
	    ary[end] = null;
	    end = end - 1;
	    return a;
	}
    }
    public String getFirst(){
	if(front == end){
	    throw new NoSuchElementException();
	}
	else{
	    return ary[front];
	}
    }
    public String getLast(){
	if(front == end){
	    throw new NoSuchElementException();
	}
	else{
	    return ary[end];
	}
    }
    public static void main (String[] args){
	MyDeque a = new MyDeque();
	a.addFirst("hi");
	a.addFirst("asdf");
	a.addLast("1");
	a.addFirst("hi");
	a.addLast("asd");
	a.addFirst("hi");
	a.addFirst("asdf");
	a.addLast("1");
	a.addFirst("hi");
	a.addLast("asd");
	a.addFirst("hi");
	a.addFirst("asdf");
	a.addLast("1");
	a.addFirst("hi");
	a.addLast("asd");
	a.removeLast();
	a.removeLast();
	a.removeFirst();
	for(int x = 0; x < a.ary.length; x ++){
	    System.out.println( a.ary[x]);
	}
    }
}
