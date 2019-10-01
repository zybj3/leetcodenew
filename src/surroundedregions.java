public class surroundedregions {
    public void solve(char[][] board) {
        if (board.length==0){
            return;
        }
        for (int i=0;i<board.length;i++){
            if (board[i][0]=='O'){
                dfs(board,i,0);
            }
            if (board[i][board[0].length-1]=='O'){
                dfs(board,i,board[0].length-1);
            }
        }

        for (int i=0;i<board[0].length;i++){
            if (board[0][i]=='O'){
                dfs(board,0,i);
            }
            if (board[board.length-1][i]=='O'){
                dfs(board,board.length-1,i);
            }
        }

        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col){
        if (board[row][col]=='O'){
            board[row][col] = '1';

            if (row+1<=board.length-1) {
                dfs(board, row + 1, col);
            }

            if (row-1>=0) {
                dfs(board, row - 1, col);
            }

            if (col+1<=board[0].length-1) {
                dfs(board, row, col + 1);
            }

            if (col-1>=0){
                dfs(board,row,col-1);
            }
        }
    }
}
