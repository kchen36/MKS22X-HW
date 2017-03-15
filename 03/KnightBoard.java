public class KnightBoard{
	private int[][] board;
	private int [] xVal = {1, 1, 2, 2, -1, -1, -2, -2};
	private int[] yVal = {2, -2, 1, -1, 2, -2, 1, -1};
	
	public KnightBoard(int x, int y){
		board = new int[x][y];
	}
	public void Solve(){
		helper(0,0,1);
	}
	public boolean helper(int x, int y , int level){
		if(level > board.length*board[0].length){
			return true;
		}
		if(x < 0 || y < 0 || x >=board.length || y >= board[0].length){
			return false;
		}
		if(board[x][y] == 0 ){
			board[x][y] = level;
			for(int i = 0 ; i < 8 ; i++){
				if(helper(x +xVal[i] , y + yVal[i] , level+1)){
					return true;
				}
			}
			board[x][y] = 0;
		}
		return false;
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
		KnightBoard test = new KnightBoard(6,6);
		test.Solve();
		System.out.println(test.toString());
	}
}
