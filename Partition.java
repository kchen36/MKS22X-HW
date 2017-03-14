import java.util.*;
public class Partition{
    public Partition(){
    }
    int part( int[] data, int start, int end){
	Random r = new Random();
	int pivot = r.nextInt(end - start);
	int val = data[pivot];
	data[pivot] = data[start];
	int holder = 0;
	int pos = end;
	for(int x = start + 1; x < end; x ++){
	    if(data[x] < val){
		holder = data[x];
		data[x] = data[pos + 1];
		data[pos + 1] = data[pos];
		data[pos] = holder;
		pos++;
	    }
	}
	return pos;
    }
}
