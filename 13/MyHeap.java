import java.util.*;
public class MyHeap{
    private String[] ary;
    private int size,constant;
    public MyHeap(){
	ary = new String[10];
	size = 0;
	constant = -1;
    }
    public MyHeap(boolean a){
	size = 0;
	ary = new String[10];
	if(a) constant = -1;
	else constant = 1;
    }
    private void resize(){
	String[] ary2 = new String[ary.length * 2];
	for(int x = 0; x < ary.length; x ++){
	    ary2[x] = ary[x];
	}
	ary = ary2;
    }
    public void add(String s){
	if(size == ary.length) resize();
	ary[size + 1] = s;
	size ++;
	if(size > 1){
	    pushUp();
	}
    }
    public String peek(){
	if(size == 0) throw new NoSuchElementException();
	return ary[1];
    }
    private void pushUp(){
	String x = ary[size];
	for(int i = size; i > 1; i/=2){
	    if(ary[i/2].compareTo(ary[i]) * constant > 0){
		ary[i] = ary[i/2];
		ary[i/2] = x;
	    }
	}
    }
    public String remove(){
	if(size == 0) throw new NoSuchElementException();
	String val = ary[1];
	ary[1] = ary[size];
	ary[size] = null;
	size --;
	pushDown();
	return val;
    } 
    private void pushDown(){
	int x = 1;
        while(x * 2 <= size){
	    String val = ary[x];
	    String bigger;
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
    public String toString(){
	String s = "";
	for(int x = 1; x<= size; x++){
	    s += ary[x] + " ";
	}
	return s;
    }
    public static void main(String[] args){
	MyHeap a = new MyHeap();
	a.add("a");
	System.out.println(a);
	a.add("b");
	System.out.println(a);
	a.add("e");
	System.out.println(a);
	a.add("c");
	System.out.println(a);
	a.add("d");
	System.out.println(a);
	a.remove();
	System.out.println(a);
	a.remove();
	System.out.println(a);
    }
}
