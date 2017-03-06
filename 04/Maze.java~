import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;
    public Maze(String filename){
	readMe(filename);
    }
    public void readMe(String filename)throws FileNotFoundException{
	File infile = new File(filename);
        Scanner inf = new Scanner(infile);
        int linelength = infile.indexOf("\n");
	String line = "";
	int lineNumber = StringUtils.countOccurrencesOf(infile,"\\") + 1;
	maze =new char[lineNumber][linelength];
	int l = 0;
	while(inf.hasNextLine()){
	    String s = inf.nextLine();
	    for(int x = 0; x < line.length();x ++){
		maze[l][x] = s.charAt(x);
	    }
	}			  
    }   
    public String toString(){
	String ans = "";
	for(int l = 0; l < maze.length; l++){
	    for(int x = 0; x < maze[l].length; x ++){
		ans += maze[l][x];
	    }
	    ans += "\n";
	}
    }
    public static void main(String[] args){
	Maze("data1.txt");
    }
}

