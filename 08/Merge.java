public class Merge{
    public Merge(){
    }
    public static void mergesort(int[] ary){
	if(ary.length <= 1){
	}
	else{
	    int[] left,right;
	    left = new int[ary.length/2];
	    right = new int[ary.length - left.length];
	    for(int x = 0;x < left.length;x ++){
		left[x] = ary[x];
	    }
	    for(int x = 0;x < right.length;x++){
		right[x] = ary[x + left.length];
	    }
	    mergesort(left);
	    mergesort(right);
	    merging(left,right,ary);
	}
    }
    public static void merging(int[] left, int[] right, int[] destination){
	int indexl = 0;
	int indexr = 0;
	while(indexl + indexr < destination.length){
	    if(indexl < left.length && indexr<right.length){
		if(left[indexl] > right[indexr]){
		    destination[indexr + indexl] = right[indexr];
		    indexr++;
		}
		else{
		    destination[indexr + indexl] = left[indexl];
		    indexl++;
		}
	    }
	    else{
		if(indexl == left.length){
		    destination[indexr + indexl] = right[indexr];
		    indexr++;
		}
		else{
		    destination[indexr + indexl] = left[indexl];
		    indexl++;
		}
	    }
	}
    }
    public static void main (String[] args){
        int[]ary = { 2, 10, 15, 23, 0,  5};
	mergesort(ary);
	for(int x = 0; x < ary.length;x ++){
	    System.out.println(ary[x]);
	}
	
    }
}
