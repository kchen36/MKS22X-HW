public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    private int queens;
    public QueenBoard(int n){
	board= new int [n][n];
	solutionCount = 0;
	queens = 0;
    }
    public void solve(){
	queens = 0;
	solveH(0,false);
    }
    private void placeQueen(int x,int y){
	board[x][y] = -1;
	plus1(x,y);
    }
    private void removeQueen(int x, int y){
	board[x][y] = 0;
	minus1(x,y);
    }
    private void plus1(int x ,int y){
	for(int val = x + 1; val <board.length;val++){
	    board[val][y] += 1;
	}
	for(int val = y  + 1; val < board.length;val++){
	    board[x][val] += 1;
	}
	for(int val = x - 1; val >= 0;val--){
	    board[val][y] += 1;
	}
	for(int val = y - 1; val >= 0;val--){
	    board[x][val] += 1;
	}
	for(int val = 1; val + x < board.length && val + y < board.length;val++){
	    board[val+ x][val + y] += 1;
	}
	for(int val = 1; val + x < board.length && y - val >= 0;val++){
	    board[x + val][y - val] += 1;
	}
	for(int val = 1; x - val >= 0 && y + val < board.length ;val++){
	    board[x - val][y + val] += 1;
	}
	for(int val = 1;y - val >= 0 && x - val >= 0;val++){
	    board[x - val][y - val] += 1;
	}
    }
    private void minus1(int x ,int y){
	for(int val = x + 1; val <board.length;val++){
	    board[val][y] -= 1;
	}
	for(int val = y + 1; val < board.length;val++){
	    board[x][val] -= 1;
	}
	for(int val = x - 1; val >= 0;val--){
	    board[val][y] -= 1;
	}
	for(int val = y - 1; val >= 0;val--){
	    board[x][val] -= 1;
	}
	for(int val = 1; val + x < board.length && val + y < board.length;val++){
	    board[val + x][val + y] -= 1;
	}
	for(int val = 1; val + x < board.length && y - val >= 0;val++){
	    board[x + val][y - val] -= 1;
	}
	for(int val = 1; x - val >= 0 && y + val < board.length ;val++){
	    board[x - val][y + val] -= 1;
	}
	for(int val = 1;y - val >= 0 && x - val >= 0;val++){
	    board[x - val][y - val] -= 1;
	}
    }
    private void solveH(int n,boolean status){
	for(int x = 0; x < board.length && n < board.length;x ++){
	    if(board[n][x] == 0){
		placeQueen(n,x);
		queens++;
		solveH(n + 1,status);
		if(queens == board.length){
		    if(status == false){
			break;
		    }else{
			solutionCount++;
		    }
		}
		removeQueen(n,x);
		queens--;
	    }
	}
    }
    public void countSolutions(){
	solutionCount = 0;
	solveH(0,true);
    }
    public int getSolutionCount(){
	if(solutionCount == 0){
	    return -1;
	}
	else{
	    return solutionCount;
	}
    }
    public String toString(){
	String ans = "";
	for(int x = 0; x < board.length;x ++){
	    for(int y = 0; y < board.length; y ++){
		if(board[x][y] == - 1){
		    ans += "Q ";
		}else{
		    ans += board[x][y] +  " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(4);
	QueenBoard b = new QueenBoard(5);
	a.solve();
	System.out.println(a);
	b.countSolutions();
	System.out.println(b.getSolutionCount());

    }
}
