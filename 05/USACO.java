import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO {
    public int E, vol; 
    public int[][] pasture;
    public USACO(){
    }
    public int Bronze(String file){
	scanner(file);
	solve()
    }
    public void scanner(String file) {
	try{
	    //instead of a try/catch, you can throw the FileNotFoundException.
	    File text = new File(file);// can be a path"/full/path/to/file.txt" 
	    Scanner inf = new Scanner(text);
	    pasture= new int[inf.nextInt()][inf.nextInt()];
	    inf.nextInt();
	    for(int a = 0; a < pasture.length;a ++){
		for(int b = 0; b < pasture[a].length;b++){
		    pasture[a][b] = inf.nextInt();
		}
	    }
	    while(inf.hasNextInt()){
		stomp(inf.nextInt(),inf.nextInt(),inf.nextInt());
	}
	catch(FileNotFoundexception e){
	}
    }
    public int solve(){
	inv val= 0;
	for(int y = 0; y < pasture.length; y ++){
	    for(int x = 0; x < pasture[y].length;x ++){
		if(pasture[y][x] < E){
		    val += E - pasture[y][x];
		}
	    }
	}
	vol = val * 72 * 72;
	return vol;
    }
    private void stomp(int row,int col,int val){
	int[] max = findGreatest(row, col);
	int min = pasture[max[0]][max[1]] - val;
	for(int r = row;r < row + 3; r ++){
	    for(int c = col; c < col + 3; c ++){
		if(isInBounds(r, c) && pasture[r][c] > min){
		    pasture[r][c] = min;
		}
	    }
	}
    }

    private int[] findGreatest(int row, int col){
	int max = pasture[row][col];
	int y = row, x = col;

	for(int r = row;r < row + 3; r ++){
	    for(int c = col; c < col + 3; c ++){
		if(isInBounds(r, c) && pasture[r][c] > max){
		    max = pasture[r][c];
		    y = r;
		    x = c;
		}
	    }
	}
	
	int[] pos = {y, x};
	return pos;
    }
    
    public boolean isInBounds(int r, int c){
	return r >= 0 && c >= 0 && r < pasture.length  && c < pasture[0].length;
    }
    public void main(String[] args){
	LakeMaking a = new LakeMaking("test.txt");
	System.out.println(a.solve());
    }
}
