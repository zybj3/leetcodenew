import java.util.Arrays;

class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[m+1][n];

        int[] sum = new int[n];
        sum[0] = nums[0];
        dp[1][0] = sum[0];
        for (int i=1; i<n; i++){
            sum[i] = sum[i-1] + nums[i];
            dp[1][i] = sum[i];
        }
        for (int i=2; i<=m; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            for (int j=i-1; j<n; j++){
                for (int k=0; k<j; k++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k],sum[j]-sum[k]));
                }
            }
        }

        return dp[m][n-1];

    }
}