public class partitionequalsubsetsum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num:nums){
            sum += num;
        }
        int[] dp = new int[sum+1];

        dp[nums[0]] = nums[0];
        if (sum-dp[nums[0]]==dp[nums[0]]){
            return true;
        }
        for (int i=1;i<nums.length;i++){
            for (int j=dp.length-1;j>=0;j--){
                if (j>=nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }

                if (sum-dp[j]==dp[j]){
                    return true;
                }
            }
        }

        return false;

    }
}
