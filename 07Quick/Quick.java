import java.util.*;
public class Quick{
    public Quick(){
    }
    public static int quickselect(int []data, int k){
	return part(data,0,data.length,k);
    }
    public static int part(int[] data, int start, int end,int k){
	if(start == end){
	    return data[start];
	}
	Random r = new Random();
	int pivot = r.nextInt(end - start);
	int val = data[pivot];
	data[pivot] = data[start];
	data[start] = val;
	int holder = 0;
	int pos = start;
	for(int x = start + 1; x < end; x ++){
	    if(data[x] < val){
		holder = data[x];
		data[x] = data[pos + 1];
		data[pos + 1] = data[pos];
		data[pos] = holder;
		pos++;
	    }
	}
	if(pos > k){
	    return part(data,start,pos - 1 ,k);
	}
	else if(pos < k){
	    return part(data,pos + 1,end,k);
	}
	else return data[pos];
	}
    public static void main(String[] args){
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(quickselect(ary, 0));
	System.out.println(quickselect(ary, 1));
	System.out.println(quickselect(ary, 2));
	System.out.println(quickselect(ary, 3));
	System.out.println(quickselect(ary, 4));
	System.out.println(quickselect(ary, 5));
    }
}
