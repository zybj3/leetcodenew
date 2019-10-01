import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class nqueens {
    List<List<String>> res = new ArrayList<>();
    int count = 0;
    public List<List<String>> solveNQueens(int n) {

        char[][] chessboard = new char[n][n];
        for (int i=0;i<n;i++) {
            Arrays.fill(chessboard[i], '.');
        }
        backtrack(chessboard,n,0);
        System.out.println(count);
        return res;
    }

    public void backtrack(char[][] chessboard,int n, int currow){
        if (currow==n){
            List<String> list = new ArrayList<>();
            for (int i=0;i<n;i++){
                String str = "";
                for (int j=0;j<n;j++){
                    str += chessboard[i][j];
                }
                list.add(str);
            }
            res.add(list);
            count++;
            return;
        }
        for (int i=0;i<n;i++){
            // System.out.println(currow);
            if (check(chessboard,currow,i))
            {
                chessboard[currow][i] = 'Q';
                backtrack(chessboard,n,currow+1);
                chessboard[currow][i] = '.';
            }
        }
    }

    public boolean check(char[][] chessboard,int row,int col){
        //row
        for (int i=0;i<chessboard.length;i++){
            if (i==col){
                continue;
            }
            if (chessboard[row][i]=='Q'){
                return false;
            }
        }

        //col
        for (int i=0;i<chessboard.length;i++) {
            if (i == row) {
                continue;
            }
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        //+diaup
        for (int i=row,j=col;i>=0&&j>=0;i--,j--){
            if (i==row&&j==col){
                continue;
            }
            if (chessboard[i][j]=='Q'){
                return false;
            }
        }

        //+diadown
        for (int i=row,j=col;i<chessboard.length&&j<chessboard.length;i++,j++){
            if (i==row&&j==col){
                continue;
            }
            if (chessboard[i][j]=='Q'){
                return false;
            }
        }

        //-diaup
        for (int i=row,j=col;i>=0&&j<chessboard.length;i--,j++){
            if (i==row&&j==col){
                continue;
            }
            if (chessboard[i][j]=='Q'){
                return false;
            }
        }

        //-diadown
        for (int i=row,j=col;i<chessboard.length&&j>=0;i++,j--){
            if (i==row&&j==col){
                continue;
            }
            if (chessboard[i][j]=='Q'){
                return false;
            }
        }


        return true;
    }


}
