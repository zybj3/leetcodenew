public class stonegame {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for (int i=0; i<piles.length; i++){
            dp[i][i] = piles[i];
        }

        for (int len = 1; len<piles.length; len++){
            for (int i = 0; i<piles.length-len; i++){
                int j = i+len;
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j]-dp[i][j-1]);
            }
        }

        return dp[0][dp.length-1]>0;

    }
}
