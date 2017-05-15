import java.util.*;
public class Quick{
    public Quick(){
    }
    public static int quicksort(int []data, int k){
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
	    return part(data,e,end,k);
	}
	else return data[pos];
    }
    public static void quicksort(int[] data){
	helper(data,0,data.length);
    }
    public static void helper(int[] data, int start,int end){
	if(start == end){
	}
	else{
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
	    helper(data,start,pos);
	    helper(data,e + 1,end);
	}
    }
    public static void main(String[] args){
	int[]ary = { 2, 2, 2, 2, 2, 2};
	quicksort(ary);
	for(int x = 0;x < ary.length;x ++){
	    System.out.println(ary[x]);
	}
    }
}
