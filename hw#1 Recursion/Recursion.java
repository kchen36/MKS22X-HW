public class Recursion{ 
    public static String name(){
	return "Chen,Kerry";
    }
    public static double sqrt(double n){
	return helper(n,1);
    }
    private boolean isCloseEnough(double val, double val2){
	if( val > val2){
	    return val2 * .00000000001 <= val - val2;
	    }
	else return val2 * .00000000001 <= val2 - val1;
    }
    private double helper(double n, double guess){
	if(isCloseEnough(n,guess)){
	    return guess;
	}
	else{
	    return helper(n, (n/guess + guess)/2);
	}
}
