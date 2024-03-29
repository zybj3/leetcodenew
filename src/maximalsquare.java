public class maximalsquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length ==0){
            return 0;
        }
        int width = 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                if (matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }
                width = Math.max(width,dp[i][j]);

            }
        }

        return width*width;

    }
}
