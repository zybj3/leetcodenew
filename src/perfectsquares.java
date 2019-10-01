public class perfectsquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i=1;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
            if (isSquare(i)){
                dp[i] = 1;
            }
            else {
                for (int j=1;j<=i/2;j++){
                    dp[i] = Math.min(dp[i],dp[j]+ dp[i-j]);
                }
            }
        }

        return dp[n];
    }

    public boolean isSquare(int n){
        int i;
        for (i=1; n>0; i+=2){
            n-=i;
        }
        return n==0;
    }
}
