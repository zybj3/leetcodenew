import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        backtrack(0,nums,list);
        return res;
    }

    public void backtrack(int start, int[] nums, List<Integer> list){
        res.add(new ArrayList<>(list));
        for (int i=start;i<nums.length;i++){
            if (i>start && nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            backtrack(i+1, nums, list);
            list.remove(list.size()-1);

        }
    }
}
