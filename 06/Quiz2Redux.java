import java.util.*;
public class Quiz2Redux{
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help(words, "", 0, s);
	Collections.sort(words);
	return words;
    }
  
    private static void help(ArrayList<String> words, String s, int index, String original){
	if(index == original.length()){
	    words.add(s);
	}
	else{
	    words.add(s);
	    help(words, s + original.charAt(index), index ++, original);
	    help(words, s,index ++, original);
	}
    }
}
