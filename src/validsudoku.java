import java.util.HashSet;

public class validsudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> set = new HashSet<>();

        for (int i=0;i<9;i+=3){
            for (int j=0;j<9;j+=3){
                if (!check3x3(board,i,j,set)){

                    return false;
                }
                set.clear();
            }
        }

        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if(board[j][i]=='.'){
                    continue;
                }
                if (!set.add(Character.getNumericValue(board[j][i]))){
                    // System.out.println(set);
                    // System.out.println("false");
                    return false;
                }
            }


            set.clear();
            for (int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if (!set.add(Character.getNumericValue(board[i][j]))){
                    return false;
                }
            }
            set.clear();
        }

        return true;
    }

    public boolean check3x3(char[][]board,int row, int col, HashSet set){
        for (int i=row;i<row+3;i++){
            for (int j=col;j<col+3;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if (!set.add(Character.getNumericValue(board[i][j]))){
                    return false;
                }
            }
        }


        return true;
    }


}
