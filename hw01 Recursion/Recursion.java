public class Recursion{
    public Recursion(){
    }
    public static String name(){
	return "Chen,Kerry";
    }
    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return helper(n,1);
    }
    private static boolean isCloseEnough(double val, double val2){
	double error = 0;
	if( val > val2){
	    return val2 * .00000000001 >= val - val2;
	    }
	else return val * .00000000001 >= val2 - val;
    }
    private static double helper(double n, double guess){
	if(isCloseEnough(n,guess * guess)){
	    return guess;
	}
	else{
	    return helper(n, (n/guess + guess)/2);
	}
    }
      public static void main(String[] args){
    double a = sqrt(1000);
    System.out.println(a);
  }
}
    /*   private int[][] board = new int[][];
     public String solution(int n){
     	board = int[n][n];
    }
    private boolean check(int x, int y){
    block(x,y)
    }
    private boolean block(int x,int y){
}
    }*/

