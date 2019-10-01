import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largestdivisiblesubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        int[] dp = new int[nums.length];
        int[] previous = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i=0;i<previous.length;i++){
            previous[i] = i;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j=0;j<i;j++){
                if (nums[i]%nums[j]==0){
                    if (dp[j]+1>dp[i]){
                        dp[i] = dp[j] + 1;
                        previous[i] = j;
                    }
                }
            }
        }



        int index = 0;
        int maxlen = dp[0];
        for (int i=1;i<dp.length;i++){
            if (dp[i]>maxlen){
                maxlen = dp[i];
                index = i;
            }
        }
        while (previous[index]!=index){
            res.add(nums[index]);
            index = previous[index];
        }

        res.add(nums[index]);

        return res;
    }


}
