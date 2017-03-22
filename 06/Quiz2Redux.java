import java.util.*;
public class Quiz2Redux{
    public Quiz2Redux(){
    }
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help(words, "", 0, s);
	Collections.sort(words);
	return words;
    }
  
    public static void help(ArrayList<String> words, String s, int index, String original){
	if(index == original.length()){
	    words.add(s);
	}
	else{
	    help(words, s + original.charAt(index), index + 1, original);
	    help(words, s,index + 1, original);
	}
    }
    public static void main(String[] args){
	Quiz2Redux a = new Quiz2Redux();
	System.out.println(a.combinations("sssssss"));
    }
}
