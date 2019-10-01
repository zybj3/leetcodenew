public class gameoflife {
    public void gameOfLife(int[][] board) {
        for (int i=0;i<board.length;i++){
            for (int j=0; j<board[0].length; j++){

                if (board[i][j]==0){
                    int count = count0(board, i, j);
                    if (count==3){
                        board[i][j] = 7;
                    }
                }
                else {
                    int count = count1(board, i, j);
                    if (count<2 || count>3){
                        board[i][j] = -1;
                    }
                }
            }
        }

        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        for (int i=0;i<board.length;i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]==7){
                    board[i][j] = 1;
                }
                else if (board[i][j]==-1){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int count0(int[][] board, int row, int col){
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        int count = 0;
        for (int i=0;i<dir.length;i++){
            int pRow = row + dir[i][0];
            int pCol = col + dir[i][1];

            if (valid(pRow,pCol,board.length,board[0].length)){
                if (board[pRow][pCol]!=0 && board[pRow][pCol]!=7){
                    count++;
                }
            }

        }
        return count;
    }

    private int count1(int[][] board, int row, int col){
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        int count = 0;
        for (int i=0;i<dir.length;i++){
            int pRow = row + dir[i][0];
            int pCol = col + dir[i][1];

            if (valid(pRow,pCol,board.length,board[0].length)){
                if (board[pRow][pCol]!=0 && board[pRow][pCol]!=7){
                    count++;
                }
            }

        }
        return count;
    }

    private boolean valid(int row, int col, int m, int n){
        // System.out.println(row +" " + col);
        return (row>=0 && row<m) && (col>=0 && col<n);
    }
}
