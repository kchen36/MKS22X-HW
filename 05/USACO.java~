import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO {
    public int E, vol; 
    public int[][] pasture;
    private int [][] field,field1;
    private int time,R1,C1,R2,C2;
    public USACO(){
    }
    public int bronze(String file){
	scanner(file);
	return solve();
    }
    public void scanner(String file) {
	try{
	    //instead of a try/catch, you can throw the FileNotFoundException.
	    File text = new File(file);// can be a path"/full/path/to/file.txt
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
    public void main(String[] args){
	USACO a = new USACO();
	System.out.println(a.bronze("lake"));
	System.out.println(a.silver("map"));
    }
}
