public class KnightBoard {
    private int[][] board;
    private int sizeR, sizeC;

    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
	sizeR = startingRows;
	sizeC = startingCols;
    }
    
    private boolean checkOpenFields(int r, int c) {
	 return (board[r+2][c+1] == 0 ||
		 board[r+2][c-1] == 0 ||
		 board[r+1][c+2] == 0 ||
		 board[r+1][c-2] == 0 ||
		 board[r-2][c+1] == 0 ||
		 board[r-2][c-1] == 0 ||
		 board[r-1][c+2] == 0 ||
		 board[r-1][c-2] == 0);
    }

     public void solve() {
	 solveH(0,0,0);
     }

     private boolean solveH (int row, int col, int level) {
	 if (level == sizeR * sizeC) {
	    return true;
	}
	 for (int r = 0; r < board.length; r++) {
	     for (int c =0; c < board[r].length; c++) {
		 if (board[row][col] == 0 && checkOpenFields(row, col)) {
		     board[row][col] = level;
		     if (solveH (r, c, level++)) {
			 return true;
		     }
		     board[row][col] = 0;
		 }
	     }
	 }
	 return false;
     }
		 
	

    public String toString() {
	String out = "";
	for (int r = 0; r < board.length; r++) {
	    out += "\n";
	    for (int c = 0; c < board[r].length; c++) {
		out += board[r][c];
	    }
	}
	return out;
    }


    public static void main(String[] args) {
	KnightBoard test = new KnightBoard(1,1);
	test.solve();
	System.out.println(test);
    }
}
