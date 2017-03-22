import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO {
    public int E, N, vol; 
    public int[][] pasture;
    private int [][] field,field1;
    private int time,R1,C1,R2,C2;
    private boolean found = false;
    public USACO(){
    }
    public int bronze(String file){
	scanner(file);
	if(found == true){
	    return solve();
	}
	else return 0;
    }
    public void scanner(String file) {
	try{
	    //instead of a try/catch, you can throw the FileNotFoundException.
	    File text = new File(file);// can be a path"/full/path/to/file.txt
	    Scanner inf = new Scanner(text);
	    pasture= new int[inf.nextInt()][inf.nextInt()];
	    E = inf.nextInt();
	    N = inf.nextInt();
	    for(int a = 0; a < pasture.length;a ++){
		for(int b = 0; b < pasture[a].length;b++){
		    pasture[a][b] = inf.nextInt();
		}
	    }
	    for(int x = 0; x < N;x ++){
		stomp(inf.nextInt(),inf.nextInt(),inf.nextInt());
	    }
	    found = true;
	}
	catch(FileNotFoundException e){
	}
    }
    public int solve(){
	int val= 0;
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
	int max = findGreatest(row, col);
	int min = max - val;
	for(int r = row - 1;r < row + 2; r ++){
	    for(int c = col - 1; c < col + 2; c ++){
		if(pasture[r][c] > min){
		    pasture[r][c] = min;
		}
	    }
	}
    }

    private int findGreatest(int row, int col){
	int max = pasture[row - 1][col - 1];
	for(int r = row-1;r < row + 2; r ++){
	    for(int c = col - 1; c < col + 2; c ++){
		if(pasture[r][c] > max){
		    max = pasture[r][c];
		}
	    }
	}
	return max;
    }
    public int silver(String filename) {
	try {
	    File text = new File(filename);
	    Scanner scanner = new Scanner(text);
	    field = new int[scanner.nextInt()][scanner.nextInt()];
	    field1 = new int[field.length][field[0].length];
	    time = scanner.nextInt();
	   
	    for (int a = 0; a < field.length; a++) {
		String x = scanner.next();
		for (int j = 0; j < field[0].length; j++) {
		    if (x.charAt(j) == '.') {
			field[a][j] = 0;
			field1[a][j] = 0;
		    }
		    else{
			field[a][j] = -1;
			field1[a][j] = -1;
		    }
		}	   
	    }
	    R1 = scanner.nextInt() - 1;
	    C1 = scanner.nextInt() - 1;
	    field[R1][C1] = 1;
	    R2 = scanner.nextInt() - 1;
	    C2 = scanner.nextInt() - 1;
	    return solve2();
	}
	catch(FileNotFoundException j) {
	    System.out.println("File not found.");
	    System.exit(0);
	}
	return 0 ;
    }
    public int solve2(){
	for(int i = 0; i < time; i++){
	    if( i % 2 == 1){
		for (int r = 0; r < field.length; r++){
		    for(int c = 0; c < field[0].length; c++){
			if (field1[r][c] > 0){
			    helper(r,c,field,field1[r][c]);
			    field1[r][c] = 0;
			}
		    }
		}
	    }
	    else{
		for(int r = 0; r < field.length; r++){
		    for(int c = 0; c < field[0].length; c++){
			if(field[r][c] > 0){
			    helper(r,c,field1,field[r][c]);
			    field[r][c] = 0;
			}
		    }
		}
	    }
	}
	
	int val = field[R2][C2] + field1[R2][C2];
	return val; 
    }

    public static void helper(int r, int c, int[][] field,int n) {
	if (field[r][c] != -1) {
	    if (r > 0) {
		field[r-1][c] += n;
	    }
	    if (c > 0) {
		field[r][c-1] += n;
	    }
	    if (r < field.length - 1) {
		field[r + 1][c] += n;
	    }
	    if (c < field[0].length - 1) {
		field[r][c + 1] += n;
	    }
	    
	}

    }
    
    public boolean isInBounds(int r, int c){
	return r >= 0 && c >= 0 && r < pasture.length  && c < pasture[0].length;
    }
    public static void main(String[] args){
	USACO a = new USACO();
	System.out.println(a.bronze("test.txt"));
	System.out.println(a.silver("map"));
    }
}
