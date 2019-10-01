public class interleavingstring {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m+n!=s3.length()){
            return false;
        }

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int i=1;i<dp.length;i++){
            if (s1.charAt(i-1)==s3.charAt(i-1) && dp[i-1][0]){
                dp[i][0] = true;
            }
        }



        for (int i=1;i<dp[0].length; i++){
            if (s2.charAt(i-1)==s3.charAt(i-1) && dp[0][i-1]){
                dp[0][i] = true;
            }
        }

        for(int i=0;i<dp[0].length;i++){
            System.out.print(dp[0][i] + " ");
        }

        for (int i=1;i<=s1.length(); i++){
            for (int j=1; j<=s2.length(); j++){
                char ch1 = s1.charAt(i-1);
                char ch2 = s2.charAt(j-1);
                char ch3 = s3.charAt(i+j-1);

                dp[i][j] = (ch1==ch3 && dp[i-1][j]) || (ch2==ch3 && dp[i][j-1]);
            }
        }

        return dp[m][n];
    }
}
