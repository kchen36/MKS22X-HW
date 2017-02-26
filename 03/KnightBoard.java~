public class KnightBoard{
    public int[][] board;
    public int level;
    public KnightBoard(int rows, int cols){
	board =  new int[rows][cols];
	level = 0;
    }
    public void move(int rows, int cols,int attempt){
	int row = board.length;
	int col = board[0].length;
	if(attempt == 0 && rows + 2 < row && cols + 1 < col){
	    if(board[rows + 2][cols + 1] == 0){
		board[rows + 2][cols + 1] = level;
		level++;
		solveH(rows + 2, cols + 1);
	    }
	}
	if(attempt == 1 && rows + 2 < row && cols - 1 >= 0){
	    if(board[rows + 2][cols - 1] == 0){
		board[rows + 2][cols - 1] = level;
		level++;
		solveH(rows + 2, cols - 1);
	    }
	}
	if(attempt == 2 && rows - 2 >= 0 && cols - 1 >= 0){
	    if(board[rows - 2][cols - 1] == 0){
		board[rows - 2][cols - 1] = level;
		level++;
		solveH(rows - 2, cols - 1);
	    }
	}
	if(attempt == 3 && rows - 2 >= 0 && cols + 1 < col){
	    if(board[rows - 2][cols + 1] == 0){
		board[rows - 2][cols + 1] = level;
		level++;
		solveH(rows - 2, cols + 1);
	    }
	}
	if(attempt == 4 && rows + 1 < row && cols + 2 < col){
	    if(board[rows + 1][cols + 2] == 0){
		board[rows + 1][cols + 2] = level;
		level++;
		solveH(rows + 1, cols + 2);
	    }
	}
	if(attempt == 5 && rows + 1 < row && cols - 2 >= 0){
	    if(board[rows + 1][cols - 2] == 0){
		board[rows + 1][cols - 2] = level;
		level++;
		solveH(rows + 1, cols - 2);  
	    }
	}
	if(attempt == 6 && rows - 1 >= 0 && cols - 2 >= 0){
	    if(board[rows - 1][cols - 2] == 0){
		board[rows - 1][cols - 2] = level;
		level++;
		solveH(rows - 1, cols -2);
	    }
	}
	if(attempt == 7 && rows - 1 >= 0 && cols + 2 < col){
	    if(board[rows - 1][cols + 2] == 0){
		board[rows - 1][cols + 2] = level;
		level++;
		solveH(rows - 1, cols + 2);
	    }
	}
    }
    public void remove(int rows,int cols){
	board[rows][cols] = 0;
	level--;
    }
    public void solve() {
	board[0][0] = 1;
	level += 1;
	solveH(0,0);
    }
    public void solveH(int rows, int cols){
	for(int attempt = 0; attempt <= 7 ; attempt++){
	    if(level == board.length * board[0].length){
		break;
	    }
	    move(rows, cols, attempt);
	}
	remove(rows,cols);
    }
    public String toString(){
	String ans = "";
	for(int x = 0; x < board.length; x ++){
	    for(int y = 0; y < board[0].length; y++){
		if(board[x][y] > 9){
		    ans += board[x][y]  + " ";
		}
		else{
		    ans += " " + board[x][y] + " ";
		}
	    }
	    ans +="\n";
	}
	return ans;
    }
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(7,7);
	a.solve();
	System.out.println(a);
    }
}
