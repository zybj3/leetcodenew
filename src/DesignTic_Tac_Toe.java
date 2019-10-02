class TicTacToe {
    int[] rowsCount;
    int[] colsCount;
    int diagonal, anti_diagonal;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rowsCount = new int[n];
        colsCount = new int[n];
        diagonal = 0;
        anti_diagonal = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int n = rowsCount.length;
        if (player==1){
            rowsCount[row]+=1;
            colsCount[col]+=1;
            if (row==col){
                diagonal++;
            }
            if (row+col==n-1){
                anti_diagonal++;
            }
        }else {
            rowsCount[row]-=1;
            colsCount[col]-=1;
            if (row==col){
                diagonal--;
            }
            if (row+col==n-1){
                anti_diagonal--;
            }
        }

        if (rowsCount[row]==n || colsCount[col]==n){
            return 1;
        }

        if (rowsCount[row]==-n || colsCount[col]==-n){
            return -2;
        }

        if (diagonal==n || anti_diagonal==n){
            return 1;
        }

        if (diagonal==-n || anti_diagonal==-n){
            return 2;
        }

        return 0;
    }
}
