import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class lakeMaking {
    public int E vol; 
    public int[][] pasture;
    public lakeMaking(file){
	scanner(file);
    }
    public void scanner(file) {
	try{
	    //instead of a try/catch, you can throw the FileNotFoundException.
	    File text = new File(file);// can be a path"/full/path/to/file.txt" 
	    Scanner inf = new Scanner(text);
	    pasture= new int[inf.nextInt()][inf.nextInt()];
	    inf.nextInt();
	    lineNumber = 1;
	    while(inf.hasNextLine() & lineNumber < pasture.length){
		String line = inf.nextLine();
		pasture[lineNumber] = line.split(" ");
	    }
	    stomp(inf.nextInt(),inf.nextInt(),inf.nextInt());
	    stomp(inf.nextInt(),inf.nextInt(),inf.nextInt());
	}
	catch(FileNotFoundexception e){
	}
    }
    public void solve(){
	inv val= 0;
	for(int y = 0; y < pasture.length; y ++){
	    for(int x = 0; x < pasture[y].length;x ++){
		if(pasture[y][x] < E){
		    val += E;
		    val -= pasture[y][x];
		}
	    }
	}
	vol = val * 72 * 72;
    }
    public String toString(){
	return "" + vol;
    }
}
