public class rotateimage {
    public void rotate(int[][] matrix) {
        int iter = matrix.length/2;
        int rotatenum = matrix.length;
        int row = 0, col = 0;
        int add1 = 0;
        while (iter>=0){
            col = 0;
            row = 0;
            for (int j=0;j<rotatenum-1;j++) {
                if(j!=0) {
                    col++;
                }
                else{
                    row += add1;
                    col += add1;
                }
                int row1 = row;
                int col1 = col;
                int[] temp = new int[4];
                for (int i = 0; i < 4; i++) {
                    temp[i] = matrix[row][col];
                    int temprow = row;
                    row = col;
                    col = matrix.length-1-temprow;
                }

                for (int i = 0; i < 4; i++) {
                    if(i>0){
                        matrix[row1][col1] = temp[i-1];
                    }
                    else{
                        matrix[row1][col1] = temp[3];
                    }
                    int temprow = row1;
                    row1 = col1;
                    col1 = matrix.length-1-temprow;
                }

            }
            add1++;
            iter--;
            rotatenum=rotatenum-2;

        }



    }

}
