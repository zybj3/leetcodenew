public class eidtdistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i=1;i<dp[0].length;i++){
            dp[0][i] = i;
        }

        for (int i=1;i<dp.length;i++){
            dp[i][0] = i;
        }

        for (int i=1; i<dp.length; i++){
            for (int j=1;j<dp[0].length; j++){
                char ch1 = word1.charAt(i - 1);
                char ch2 = word2.charAt(j - 1);
                if (ch1==ch2){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = getMin(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];

    }

    public int getMin(int num1, int num2, int num3){
        return Math.min(Math.min(num1, num2), num3);
    }
}
