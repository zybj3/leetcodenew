import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class subarrayproductlessthanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int fast = 0, slow = 0, cur = 1, count = 0;
        while (fast<nums.length){
            cur *= nums[fast];
            while (cur>=k && slow<=fast){
                cur /= nums[slow];
                slow ++;
            }

            count += fast-slow+1;
            fast++;
        }

        return count;
    }
}
