import java.util.*;
public class StackCalc{
    public StackCalc(){
    }
    public static boolean isOp(String x){
	return x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") || x.equals("%");
    }
    public static double compute(String func,Double val, double val2){
	if(func.equals("+")) return val2 + val;
	if(func.equals("-")) return val2 - val;
	if(func.equals("*")) return val2 * val;
	if(func.equals("%")) return val2 / val;
	else return val2 % val;
    }
    public static double eval(String a){
	String[] token = a.split(" ");
	Stack<Double> b = new Stack<Double>();
	for(int x = 0; x < token.length; x ++){
	    if(isOp(token[x])){
		b.push(compute(token[x],b.pop(),b.pop()));
	    }
	    else{
		b.push(Double.parseDouble(token[x]));
	    }
	}
	return b.pop();
    }
    public static void main(String[] args){
	System.out.println(StackCalc.eval("10 2 +"));//12.0
	System.out.println(StackCalc.eval("10 2 -"));//8.0
	System.out.println(StackCalc.eval("10 2.0 +"));//12.0
	System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0
	System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//839.0
	System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }
}
