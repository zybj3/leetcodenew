public class besttimetobuyandsellstock4 {
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length<2){
            return 0;
        }


        if (k>=prices.length/2){
            int max = 0;
            for (int i=1;i<prices.length;i++){
                if (prices[i]>prices[i-1]){
                    max += prices[i] - prices[i-1];
                }
            }

            return max;
        }


        int[][] dp = new int[k+1][prices.length];
        for (int i=1; i<=k; i++){
            int minbuy = prices[0];
            for (int j=1; j<prices.length; j++){
                dp[i][j] = Math.max(dp[i][j-1], prices[j] - minbuy);
                minbuy = Math.min(minbuy, prices[j]- dp[i-1][j-1]); //当前价格减去前方获利最大值等于最小买价
            }
        }

        return dp[k][prices.length-1];
    }
}
