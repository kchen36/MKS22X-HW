public class Location implements Comparable{
    private int row,col;
    private int distToGoal;
    private Location previous;
    private boolean aStar;
    public Location(int r,int c, Location prev, int start, int goal, boolean a){
	row = r;
	col = c;
	previous = prev;
	distToStart = start;
	distToGoal = goal;
	aStar = a;
    }
}
