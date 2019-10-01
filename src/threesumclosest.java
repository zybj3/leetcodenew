import java.util.Arrays;
import java.util.HashMap;

public class threesumclosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left, right;
            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] < target - nums[i]) {
                    int diff1 = Math.abs(target-(nums[i]+nums[left]+nums[right]));
                    if(diff1<diff){
                        diff = diff1;
                        sum = nums[i] + nums[left] + nums[right];
                    }
                    left++;

                } else if (nums[left] + nums[right] > target - nums[i]) {
                    int diff1 = Math.abs(target-(nums[i]+nums[left]+nums[right]));
                    if(diff1<diff){
                        diff = diff1;
                        sum = nums[i] + nums[left] + nums[right];
                    }
                    right--;
                } else {
                    return target;
                }
            }




        }

        return sum;
    }

    public static void main(String[] args){
        int[] nums = {-1,2,1,4};
        new threesumclosest().threeSumClosest(nums,1);
    }
}
