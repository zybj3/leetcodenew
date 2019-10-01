public class wordsearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0)){
                    //System.out.println(board[i][j]);
                    if (dfs(board,used,word,i,j,0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col,int index){
        // System.out.println(board[row][col] + " " + index);
        if (index==word.length()){
            return true;
        }
        if (row>=board.length || col>=board[0].length || row<0 || col<0){

            return false;
        }

        if (visited[row][col]){

            return false;
        }

        if (board[row][col] == word.charAt(index)){

            visited[row][col] = true;
            boolean res =  dfs(board,visited,word,row+1,col,index+1) || dfs(board,visited,word,row,col+1,index+1)
                    ||dfs(board,visited,word,row-1,col,index+1)||dfs(board,visited,word,row,col-1,index+1);
            visited[row][col] = false;
            return res;

        }

        return false;
    }
}
