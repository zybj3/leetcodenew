import java.util.ArrayList;
import java.util.List;

public class spiralmatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int colstart = 0;
        int colend = matrix[0].length-1;
        int rowstart = 0;
        int rowend = matrix.length-1;

        while (rowstart<=rowend && colstart<=colend){
            for (int i = colstart;i <= colend;i++){
                list.add(matrix[rowstart][i]);
            }
            rowstart++;

            for (int i = rowstart;i <= rowend;i++){
                list.add(matrix[colend][i]);
            }
            colend--;

            if (rowend<=rowstart){
                for (int i=colend;i>=colstart;i--){
                    list.add(matrix[rowend][i]);
                }
            }
            rowend--;

            if (colstart<=colend){
                for (int i=rowend;i>=rowstart;i--){
                    list.add(matrix[i][colstart]);
                }
            }

            colstart++;
        }
        return list;
    }
}
