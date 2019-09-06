public class NQueens {
	private int n;
	private boolean[][] board; //2d-array for the board. false = no queen, true = queen
	private boolean solutionFound; //Boolean that determines if a solution is found.
	//Constructor of the class
	public NQueens(int n)
	{
		this.n = n;
		board = new boolean[n][n]; //This initializes all the positions as false 
		solutionFound = false; 
	}
	//Method that solves the puzzle by placing the N queens. 
	public boolean placeNQueens() throws Exception {
		//Before it is solved, it checks if the size is valid. If not valid, throw Exception
		if(n < 1)
			throw new Exception("The size must be greather than 0.");
			solutionFound = placeNQueens(0); 
		return solutionFound;
	}
	//Recursive method that solves it
	private boolean placeNQueens(int col) {
		if(col == n)
		{
			return true;
		}
		for(int i = 0; i < n; i++)
		{
			if(isSafeMove(i, col))
			{
				board[i][col] = true;
				if(placeNQueens(col+1))
					return true;
				else
					board[i][col] = false; //This removes the queen placed before going to the next loop
			}
		}
		return false;
	}
	//Method that checks for a safe move for the given row and col
	private boolean isSafeMove(int row, int col) {
		//This method just calls all the checks (diagonals and left of the row), if they're true, then true
		if(checkLeft(row, col) && checkLowerDiag(row, col) && checkUpperDiag(row, col))
		{
			return true;
		}
		else
			return false;
	}
	//Method that checks the upper diagonal for a given row and col
	private boolean checkUpperDiag(int row, int col) {
		//We check the upper left diagonal by knowing both indices of the diagonal are decreasing by 1
		int i = row-1;
		int j = col-1;
		while(i >= 0 && j >= 0)
		{
			if(board[i][j])
				return false;
			i--;
			j--;
		}
		return true;
	}
	//Method that checks the lower diagonal for a given row and col
	private boolean checkLowerDiag(int row, int col) {
		//We check the lower left diagonal, knowing the rows are increasing and the columns are decreasing by 1
		int i = row+1;
		int j = col-1;
		while(i < n && j >= 0)
		{
			if(board[i][j])
				return false;
			i++;
			j--;
		}
		return true;
	}
	//Method that checks the left side of the row at the given col
	private boolean checkLeft(int row, int col) {
		//Here, to check all the left of the row, it does a simple loop decreasing the columns by 1
		int j = col-1;
		while(j >= 0) 
		{
			if(board[row][j]) 
				return false;
			j--;
		}
		return true;
	}
	//Method that prints the board to console (remove static because myboard can't be called because it is non-static)
	public void printToConsole(int[][] myboard) {
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				if(board[i][j] == true) { 
					System.out.println("Q\t");
				} else { System.out.println("-\t"); }
			}
			System.out.println();
		}
	}
}
