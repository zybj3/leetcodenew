public class scoreafterflippingmatrix {
    public int matrixScore(int[][] A) {
        int res = 0;
        for (int row = 0; row < A.length; row++){
            if (A[row][0]==0){
                flippingrow(A,row);
            }
        }

        res += Math.pow(2,A[0].length-1)*A.length;

        for (int col = 1;col <A[0].length; col++){
            int count1 = 0;
            for (int row = 0;row < A.length; row++){
                if (A[row][col]==1){
                    count1++;
                }
            }
            if (count1>=A.length-count1){
                res += Math.pow(2,A[0].length-1-col)*count1;
            }
            else res += Math.pow(2,A[0].length-1-col)*(A.length-count1);
        }


        return res;



    }

    public void flippingrow(int[][]A, int row){
        for (int col = 0; col<A[0].length; col++){
            A[row][col] = 1 - A[row][col];
        }
    }
}
