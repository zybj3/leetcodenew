public class guessnumberhigherorlower {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return dp(1,n,dp);
    }

    private int dp(int start, int end, int[][] dp){
        if (start>=end){
            return 0;
        }

        if (dp[start][end]!=0){
            return dp[start][end];
        }

        int min = Integer.MAX_VALUE;
        for (int i=start;i<=end;i++){
            /*举个例子 1-4
            取1为界 那么 左边等于 0 右边等于 3 1+3=4
            取2为界 那么 左边 0 右边等于 3 2+3 = 5
            取3为界 那么 左边 等于 1 右边等于 0 3+1 = 4；
            取4为界 那么 左边等于2 右边等于0 4+2 = 6；
            所以最小值为4
             */
            int temp = i + Math.max(dp(start,i-1,dp),dp(i+1,end,dp));
            min = Math.min(temp,min);
        }
        dp[start][end] = min;
        return min;
    }
}
