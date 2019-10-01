public class decodeways {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        if (Integer.parseInt(s.substring(0,1))!=0){
            dp[1] = 1;
        }
        else {
            dp[1] = 0;
        }

        for (int i=2;i<=n;i++){
            if (Integer.parseInt(s.substring(i-1,i))!=0){
                dp[i] += dp[i-1];
            }
            if (Integer.parseInt(s.substring(i-2,i))>=10 && Integer.parseInt(s.substring(i-2,i))<=26){
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}
