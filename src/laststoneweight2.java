public class laststoneweight2 {
    /*
    s = s1 + s2;
    s1-s2 = diff;
    so, diff = s - 2s2;
    to maximize s2, 背包问题思想，一个重量为s/2的背包，装尽量多的货物（质量越大越好）
     */
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int num:stones){
            total += num;
        }
        int[] dp = new int[total+1];

        int res = 1000000;
        for (int i=0;i<stones.length;i++){
            for (int j=total;j>=0;j--){
                if (j>=stones[i]) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                    res = total-2*dp[j]>=0? Math.min(res,total-2*dp[j]):res;
                }
            }
        }

        return res;
    }
}
