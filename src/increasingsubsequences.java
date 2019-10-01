import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class increasingsubsequences {
    Set<String> set = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,nums,list,res);
        return res;
    }

    public void dfs(int index, int[] nums, List<Integer> list, List<List<Integer>> res){
        // if (index>=nums.length){
        //     return;
        // }

        if (list.size()>=2){
            if (set.add(list.toString())) {
                res.add(new ArrayList<>(list));
            }
        }

        for (int i=index;i<nums.length;i++){
            if (list.size()==0 || nums[i]>=list.get(list.size()-1)){
                list.add(nums[i]);
                dfs(i+1,nums,list,res);
                list.remove(list.size()-1);
            }
        }

    }
}
