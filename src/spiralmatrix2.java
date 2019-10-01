public class spiralmatrix2 {
    public int[][] generateMatrix(int n) {
        int rowstart = 0,colstart = 0;
        int rowend = n-1,colend = n-1;
        int[][] matrix = new int[n][n];
        int num = 1;
        while (rowstart<=rowend && colstart<=colend){
            for (int i=colstart;i<=colend;i++){
                matrix[rowstart][i] = num;
                num++;
            }
            rowstart++;

            for (int i=rowstart;i<=rowend;i++){
                matrix[i][colend] = num;
                num++;
            }
            colend--;

            if (colstart<=colend){
                for (int i=colend;i>=colstart;i--){
                    matrix[rowend][i] = num;
                    num++;
                }
            }
            rowend--;

            if (rowstart<=rowend){
                for (int i=rowend;i>=rowstart;i--){
                    matrix[i][colstart] = num;
                    num++;
                }
            }
            colstart++;
        }

        return matrix;
    }
}
