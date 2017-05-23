import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class MazeSolver extends Maze{
    private Maze board;
    private boolean animate;
    private int row, col;
    Location e;
    private boolean astar;
    public MazeSolver(String filename){
	this(filename);
	astar = false;
    }
    public MazeSolver(String filename, boolean ani){
	this(filename);
	animates = ani;
	astar = false;
    }
    public solve(){
	solve(1);
    }
    public void solve(int x){
	Frontier f;
	astar = false;
	if(x == 0){
	    f = new FrontierStack();
	}
	else if(x == 1){
	    f = new FrontierQueue();
	}
	else if(x == 2){
	    f = new FrontierPriorityQueue();
	}
	else if(x == 3){
	    f = new FrontierPriority queue();
	    astar = true;
	}
	else throw new IllegalArgumentException();
	e = board.getEnd();
	f.add(board.getStart());
	row = board.getRow();
	col = board.getCol();
	go();
	
    }
    private boolean inBound(int r, int c){
	return r >= 0 && c >= 0 && r< row && c < col; && maze.get(r,c) ==' ';
    }
    public String toString(){
	if (animate) {
	    return board.toString(25);
	}
	else return board.toString();
    }
    private void go(){
	er = e.getr();
	ec = e.getc();
	while(f.hasNext()){
	    Location l = f.next();
	    r = l.getr();
	    c = l.getc();
	    board.set(r,c,'.');
	    if(inBound(r - 1, c)){
		if(r - 1 == er && c == ec){
		    board.set(r - 1,c,'@');
		    back(l);
		    break;
		}
		else {
		    int d = = Math.abs(er - (r - 1)) + Math.abs(ec - c);
		    board.set(r - 1,c,'?');
		    Location n = new Location(r - 1,c,l,l.gets() + 1, d, astar);
		    f.add(n);
		}
	    }
	    if(inBound(r, c - 1)){
		if(r == er && c - 1 == ec){
		    board.set(r,c - 1,'@');
		    back(l);
		    break;
		}
		else {
		    int d = = Math.abs(er - r) + Math.abs(ec - (c - 1));
		    board.set(r,c - 1,'?');
		    Location n = new Location(r,c - 1,l,l.gets() + 1, d, astar);
		    f.add(n);
		}
	    }
	    if(inBound(r + 1, c)){
		if(r + 1 == er && c == ec){
		    board.set(r + 1,c,'@');
		    back(l);
		    break;
		}
		else {
		    int d = = Math.abs(er - (r + 1)) + Math.abs(ec - c);
		    board.set(r + 1,c,'?');
		    Location n = new Location(r + 1,c,l,l.gets() + 1, d, astar);
		    f.add(n);
		}
	    }
	    if(inBound(r, c + 1)){
		if(r == er && c + 1 == ec){
		    board.set(r,c + 1,'@');
		    back(l);
		    break;
		}
		else {
		    int d = = Math.abs(er - r) + Math.abs(ec - (c + 1));
		    board.set(r,c + 1,'?');
		    Location n = new Location(r,c + 1,l,l.gets() + 1, d, astar);
		    f.add(n);
		}
	    }
	    if(animate){
		board.toString(25);
	    }
	} 
    }
    private void back(Location l){
	if(l.prev() != null){
	    board.set(l.getr,l.getc,'@');
	    back(l.prev());
	}
	if(animate){
	    maze.toString(25);
	}
    }
    public static void main(String[] args){
	MazeSolver ms = new MazeSolver("data4.txt");
	ms.solve(2);
    }
    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	for(int i = 0; i < maxr * maxc; i++){
	    int row = i/maxc;
	    int col = i%maxc;

	    char c =  maze[row][col];
	    ans+=c;
	    if( col == maxc-1 ){
		ans += "\n";
	    }

	}
	return ans + "\n";
    }
}
