import java.util.*;
public class RunningMedian{
    private double median;
    private MyHeap min, max;
    private int size;
    public RunningMedian(){
	min = new MyHeap(false);
	max = new MyHeap();
	size = 0;
    }
    public void add(int val){
	if(size == 0){
	    min.add(val);
	    median = val;
	    size ++;
	}
	else if(val < median){
	    max.add(val);
	    size ++;
	    if(max.size - 1 > min.size){
		min.add(max.remove());
	    }
	    if(size % 2 == 0){
		median = min.peek() + max.peek();
		median = median / 2;
	    }
	    else if(min.size > max.size){
		median = min.peek();
	    }
	    else median = max.peek();
	}
	else{
	    min.add(val);
	    size ++;
	    if(min.size - 1 > max.size){
		max.add(min.remove());
	    }
	    if(size % 2 == 0){
		median = min.peek() + max.peek();
		median = median / 2;
	    }
	    else if(min.size > max.size){
		median = min.peek();
	    }
	    else median = max.peek();
	}
    }
    public double getMedian(){
	return median;
    }
    private class MyHeap{
	private int[] ary;
	private int size,constant;
	public MyHeap(){
	    ary = new int[10];
	    size = 0;
	    constant = -1;
	}
	public MyHeap(boolean a){
	    size = 0;
	    ary = new int[10];
	    if(a) constant = -1;
	    else constant = 1;
	}
	private void resize(){
	    int[] ary2 = new int[ary.length * 2];
	    for(int x = 0; x < ary.length; x ++){
		ary2[x] = ary[x];
	    }
	    ary = ary2;
	}
	public void add(int s){
	    if(size == ary.length) resize();
	    ary[size + 1] = s;
	    size ++;
	    if(size > 1){
		pushUp();
	    }
	}
	public int peek(){
	    if(size == 0) throw new NoSuchElementException();
	    return ary[1];
	}
	private void pushUp(){
	    int x = ary[size];
	    for(int i = size; i > 1; i/=2){
		if(ary[i/2]* constant > ary[i] * constant){
		    ary[i] = ary[i/2];
		    ary[i/2] = x;
		}
	    }
	}
	public int remove(){
	    if(size == 0) throw new NoSuchElementException();
	    int val = ary[1];
	    ary[1] = ary[size];
	    ary[size] = 0;
	    size --;
	    pushDown();
	    return val;
	} 
	private void pushDown(){
	    int x = 1;
	    while(x * 2 <= size){
		int val = ary[x];
		int bigger;
		int dir;
		if(x * 2 < size){
		    if(ary[x * 2] * constant < ary[x * 2 + 1] * constant){
			bigger = ary[x * 2];
			dir = 0;
		    }
		    else{
			bigger = ary[x * 2 + 1];
			dir = 1;
		    }
		    if(ary[x * 2 + dir] * constant < ary[x] * constant){
			ary[x] = ary[x * 2 + dir];
			ary[x * 2 + dir] = val;
			x = x * 2 + dir;
		    }
		    else break;
		}
		else if(x* 2 <= size && ary[x * 2] * constant < ary[x] * constant){
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
    }
    public static void main(String[] args){
	RunningMedian a = new RunningMedian();
        a.add(1);
	System.out.println(a.getMedian());
	a.add(2);
	System.out.println(a.getMedian());
	a.add(3);
	System.out.println(a.getMedian());
	a.add(4);
	System.out.println(a.getMedian());
    }
}
