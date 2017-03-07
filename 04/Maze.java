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
	return go();
    }
    private boolean go(){
	if(maze[xval + 1][yval]=='E' ||maze[xval - 1][yval]=='E'||maze[xval][yval + 1]=='E'|| maze[xval][yval - 1]=='E'){
	    maze[xval][yval] = '@';
	    return true;
	}
	if(maze[xval + 1][yval]==' '){
	    maze[xval][yval] ='@';
	    xval += 1;
	    return go();
	}
	if(maze[xval - 1][yval]==' '){
	    maze[xval][yval] ='@';
	    xval -= 1;
	    return go();
	}
	if(maze[xval][yval + 1]==' '){
	    maze[xval][yval] ='@';
	    yval += 1;
	    return go();
	}
	if(maze[xval][yval - 1]==' '){
	    maze[xval][yval] ='@';
	    yval -= 1;
	    return go();
	}
	if(maze[xval + 1][yval]=='@'){
	    maze[xval][yval] ='.';
	    xval += 1;
	    return go();
	}
	if(maze[xval - 1][yval]=='@'){
	    maze[xval][yval] ='.';
	    xval -= 1;
	    return go();
	}
	if(maze[xval][yval + 1]=='@'){
	    maze[xval][yval] ='.';
	    yval += 1;
	    return go();
	}
	if(maze[xval][yval - 1]=='@'){
	    maze[xval][yval] ='.';
	    yval -= 1;
	    return go();
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
    public void readMe(String filename){
	File text = new File(filename);
        try{
	    Scanner inf = new Scanner(text);
	    int lineNumber = 1;
	    String line="";
	    while(inf.hasNextLine()){
		line = inf.nextLine();
		lineNumber++;
	    }
	    maze=new char[lineNumber][line.length()];

	    Scanner inf2 = new Scanner(text);
	    lineNumber=0;
	    while(inf2.hasNextLine()){
		line = inf2.nextLine();
		for(int i=0;i<line.length();i++){
		    maze[lineNumber][i]=line.charAt(i);
		}
		lineNumber++;
	    }
	}
	catch(FileNotFoundException e){
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
	return ans;
    }
    public static void main(String[] args){
	Maze a = new Maze("data1.txt");
	a.solve();
	System.out.println(a);
    }
}

