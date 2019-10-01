import java.util.ArrayList;
import java.util.List;

public class subsets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        backtrack(0,nums,list);
        return res;
    }

    public void backtrack(int start, int[] nums,List<Integer> list){
        res.add(new ArrayList(list));
        for (int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(i+1, nums, list);
            list.remove(list.size()-1);
        }
    }
}
