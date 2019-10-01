public class onesandzeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i=0;i<strs.length;i++){
            int[] count = count(strs,i);
            for (int i1 = m;i1>=count[0];i1--){
                for (int i2 = n;i2>=count[1];i2--){
                    dp[i1][i2] = Math.max(dp[i1][i2],dp[i1-count[0]][i2-count[1]]+1);
                }
            }
        }

        return dp[m][n];
    }

    public int[] count(String[] srts, int index){
        int[] count = new int[2];
        for (int i=0;i<srts[index].length();i++){
            if (srts[index].charAt(i)=='0'){
                count[0]++;
            }else count[1]++;
        }

        return count;
    }
}
