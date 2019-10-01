import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class sudokuSolver {
    List<Integer> rowlist = new ArrayList<>();
    List<Integer> collist = new ArrayList<>();
    public void solveSudoku(char[][] board) {

        for (int i=0;i<board.length;i++){
            for (int j=0; j<board.length; j++){
                if (board[i][j]=='.'){
                    rowlist.add(i);
                    collist.add(j);
                }
            }
        }

        backtrack(0,board);

    }

    private boolean backtrack(int index, char[][] board){
        if (index==rowlist.size()){
            return true;
        }

        int row = (int) rowlist.get(index);
        int col = (int) collist.get(index);

        char[] candidate = {'1','2','3','4','5','6','7','8','9'};
        for (int i=0;i<9;i++){
            if (isValidSudoku(board,candidate[i],row,col)){
                board[row][col] = candidate[i];
                boolean res = backtrack(index + 1, board);
                if (res){
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;

    }

    public boolean isValidSudoku(char[][] board, char num, int row, int col) {
        for(int i = 0; i<9; i++){
           if (board[row][i] == num || board[i][col] == num){
               return false;
            }
        }

        int rowoff = (row/3)*3;
        int coloff = (col/3)*3;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (board[rowoff+i][coloff+j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        sudokuSolver slover = new sudokuSolver();
        slover.solveSudoku(board);
    }



}
