import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;
    private int xval,yval;
    public Maze(String filename){
	readMe(filename);
	animate = false;
    }
    private boolean findStart(){
	for(int x = 0; x < maze.length;x ++){
	    for(int y =0; y < maze[x].length;y ++){
		if(maze[x][y] == 'S'){
		    xval = x;
		    yval = y;
		    maze[x][y] ='S';
		    return true;
		}
	    }
	}
	return false;
    }
    public boolean solve(){
	findStart();
	go();
    }
    private boolean go(){
	if(maze[xval + 1][yval]=='E' ||maze[xval - 1][yval]=='E'||maze[xval][yval + 1]=='E'|| maze[xval][yval - 1]=='E'){
	    return true;
	}
	if(maze[xval + 1][yval]==' '){
	    maze[xval][yval] ='@';
	    xval += 1;
	    go();
	}
	if(maze[xval - 1][yval]==' '){
	    maze[xval][yval] ='@';
	    xval -= 1;
	    go();
	}
	if(maze[xval][yval + 1]==' '){
	    maze[xval][yval] ='@';
	    yval += 1;
	    go();
	}
	if(maze[xval][yval - 1]==' '){
	    maze[xval][yval] ='@';
	    yval -= 1;
	    go();
	}
	if(maze[xval + 1][yval]=='@'){
	    maze[xval][yval] ='.';
	    xval += 1;
	    go();
	}
	if(maze[xval - 1][yval]=='@'){
	    maze[xval][yval] ='.';
	    xval -= 1;
	    go();
	}
	if(maze[xval][yval + 1]=='@'){
	    maze[xval][yval] ='.';
	    yval += 1;
	    go();
	}
	if(maze[xval][yval - 1]=='@'){
	    maze[xval][yval] ='.';
	    yval -= 1;
	    go();
	}
	return false;
    }
    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
    public void setAnimate(boolean b){
        animate = b;
    }
    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }
    public void readMe(String filename)throws FileNotFoundException{
	File infile = new File(filename);
        Scanner inf = new Scanner(infile);
	String str =inf.toString();
	if(str.indexOf('E') != -1 || str.indexOf('S') != -1){
	    int linelength = str.indexOf("\n");
	    String line = "";
	    int lineNumber = str.split("\n").length;
	    maze =new char[lineNumber][linelength];
	    int l = 0;
	    while(inf.hasNextLine()){
		String s = inf.nextLine();
		for(int x = 0; x < line.length();x ++){
		    maze[l][x] = s.charAt(x);
		}
		l++;
	    }			  
	}
	else System.out.println("No start or end");
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
	Maze a = new Maze("data1.txt");
	a.solve();
	System.out.println(a);
    }
}

