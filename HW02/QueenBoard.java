public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    public Queenboard(int n){
	board= new int [n][n];
    }
    public void solve(){
	solveH(0);
    }
    private void placeQueen(int x,int y){
	if(board[x][y] == 0){
	    board[x][y] = -1;
	    plus1(x,y);
	}
    }
    private void plus1(int x ,int y){
	if(x >= 1){
	    for(int val = x; val >=0;val++){
		if(board[val][y]
	    }
	}
    }
    private void solveH(int n){
	for(int x = 0; x < board.length();x ++){
	    placeQueen
	}
    }
}


