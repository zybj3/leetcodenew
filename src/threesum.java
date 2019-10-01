import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threesum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0;i<nums.length-2;i++){
            int left,right;
            left = i+1;
            right = nums.length-1;
            if (i>0){
                if (nums[i]==nums[i-1]){
                    continue;
                }
            }
            while (left < right){
                if (left>i+1 && nums[left]==nums[left-1]) {
                    left++;
                    continue;
                }
                if (right<nums.length-1 && nums[right]==nums[right+1]){
                    right--;
                    continue;
                }

                if (nums[left]+nums[right]<-nums[i]){
                    left++;
                }
                else if (nums[left]+nums[right]>-nums[i]){
                    right--;
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                }
            }
        }


        return res;


    }
}
