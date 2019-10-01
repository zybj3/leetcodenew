public class a01matrix {
    //dp solution
    public int[][] updateMatrix(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    dp[i][j] = 0;
                }
                else {
                    int upper = i>=1 ? dp[i-1][j] : 100000;
                    int left = j>=1 ? dp[i][j-1] : 100000;

                    dp[i][j] = Math.min(upper,left) + 1;
                }
            }
        }


        for (int i=matrix.length-1;i>=0;i--){
            for (int j=matrix[0].length-1;j>=0;j--){
                if (matrix[i][j]==0){
                    dp[i][j] = 0;
                }
                else {
                    int lower = i<matrix.length-1 ? dp[i+1][j] : 10000;
                    int right = j<matrix[0].length-1 ? dp[i][j+1] : 10000;

                    dp[i][j] = Math.min(Math.min(lower,right) + 1,dp[i][j]);
                }
            }
        }

        return dp;
    }
}
