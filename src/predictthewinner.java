import java.util.HashMap;

public class predictthewinner {
    int[] dp;
    public boolean PredictTheWinner(int[] nums) {
        dp = new int[nums.length*nums.length];
        return getmax(0,nums.length-1,nums)>=0;
    }

    public int getmax(int left, int right, int[] nums){
        if (left==right){
            return nums[left];
        }
        int index = left*nums.length+right;
        if (dp[index]!=0){
            return dp[index];
        }
        dp[index] =  Math.max((nums[left]-getmax(left+1,right,nums)),(nums[right]-getmax(left,right-1,nums)));
        return dp[index];
    }
}
