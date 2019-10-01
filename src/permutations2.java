import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length]);
        return res;
    }

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public void dfs(int[] nums, boolean[] visited){
        if (list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }


        for (int i=0; i<nums.length; i++){
            if (i>0 && nums[i]==nums[i-1] && !visited[i-1]){
                continue;
            }
            if (!visited[i]){
                list.add(i);
                visited[i] = true;
                dfs(nums, visited);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
