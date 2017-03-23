import java.util.*;
public class Quick{
    public Quick(){
    }
    public static int quickselect(int []data, int k){
	return part(data,0,data.length,k);
    }
    public static void swap(int[] num,int a, int b){
	int holder = num[a];
	num[a] = num[b];
	num[b] = holder;
    }
    public static int part(int[] data, int start,int end,int k){
	if(start == end){
	    return data[start];
	}
	Random r = new Random();
	int pivot = r.nextInt(end - start) + start;
	int val = data[pivot];
	data[pivot] = data[start];
	data[start] = val;
	int pos = start;
	int i = start + 1;
	int e = end - 1;
	while(i <= e){
	    if(data[i] == val){
		i++;
	    }
	    else if(data[i] < val){
		swap(data,i,pos + 1);
		pos++;
		i++;
	    }
	    else{
		swap(data,i,e);
		e--;
	    }
	}
	swap(data,start,pos);
		if(pos > k){
	    return part(data,start,pos,k);
	}
	else if(pos < k){
	    return part(data,pos,end,k);
	}
	else return data[pos];
    }
    public static int quicksort(int[] data, int start, int end,int k){
	if(start == end){
	    return data[start];
	}
	Random r = new Random();
	int pivot = r.nextInt(end - start);
	int val = data[pivot + start];
	data[pivot + start] = data[start];
	data[start] = val;
	int holder = 0;
	int pos = start;
	for(int x = start + 1; x < end ; x ++){
	    if(data[x] < val){
		holder = data[x];
		data[x] = data[pos + 1];
		data[pos + 1] = data[pos];
		data[pos] = holder;
		pos++;
	    }
	}
	if(pos > k){
	    return part(data,start,pos,k);
	}
	else if(pos < k){
	    return part(data,pos,end,k);
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
