public class regularexpressionmatching {
//    public boolean isMatch(String s, String p) {
//        return Match(0,0, s, p);
//    }

    private boolean Match(int i, int j, String s, String pattern){
        if (i>=s.length() && j>=pattern.length()){
            return true;
        }

        if (i<s.length() && j>=pattern.length()){
            return false;
        }



        // if(i>=s.length() && j+1<pattern.length() && pattern.charAt(j+1)!='*'){
        //     return false;
        // }

        if (j+1<pattern.length() && pattern.charAt(j+1)=='*'){
            if(i>=s.length()){
                return Match(i,j+2, s, pattern);
            }
            if (s.charAt(i)==pattern.charAt(j) || pattern.charAt(j)=='.'){
                return Match(i+1,j+2, s, pattern) || //move to the next state
                        Match(i+1, j, s, pattern) || //stay on current state
                        Match(i, j+2, s, pattern); // ignore '*'
            }
            else {
                return Match(i,j+2,s,pattern);
            }
        }

        if(i>=s.length()){
            return false;
        }
        if (s.charAt(i)==pattern.charAt(j) || pattern.charAt(j)=='.'){
            return Match(i+1, j+1, s, pattern);
        }

        return false;
    }

    public boolean isMatch(String s, String p){
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i=2;i<dp[0].length;i++){
            if (p.charAt(i-1)=='*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                if (s.charAt(i-1)==p.charAt(j-1) ||p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                    }else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
