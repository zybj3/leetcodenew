public class chanmagnetower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured==0){
            return 0;
        }
        if(query_row==0){
            return poured>1?1:poured;
        }
        double[][] tower = new double[query_row+1][query_row+1];
        tower[0][0] = 1-poured;

        for (int i=1;i<=query_row;i++){
            for (int j=0;j<i+1;j++){
                if (tower[i-1][j]<0){
                    tower[i][j] += -tower[i-1][j]/2;
                }
                if (j>0 && tower[i-1][j-1]<0){
                    tower[i][j] += -tower[i-1][j-1]/2;
                }

                if (tower[i][j]>1){
                    tower[i][j] = 1 - tower[i][j];
                }
            }
        }

        return tower[query_row][query_glass]<0?1:tower[query_row][query_glass];
    }
}
