public class besttimetobuyandsellstock3 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2){
            return 0;
        }
        int[][] dp = new int[3][prices.length];
        for (int i=1; i<=2; i++){
            int minbuy = prices[0];
            for (int j=1; j<prices.length; j++){
                dp[i][j] = Math.max(dp[i][j-1], prices[j] - minbuy);
                minbuy = Math.min(minbuy, prices[j]- dp[i-1][j-1]); //当前价格减去前方获利最大值等于最小买价
            }
        }

        return dp[2][prices.length-1];
    }
}
