import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class permutation2 {
    HashSet<List<Integer>> set = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        int[] visited = new int[length];
        helper(nums,list,visited,0,length,1);
        return res;
    }

    public void helper(int[] nums, List<Integer> list, int[] visited,int index,int length,int time){
        // for(int i:visited){
        // System.out.print(i + " ");
        //  }
        //  System.out.println();
        if (time==length+1){
            List<Integer> list1 = new ArrayList<>();
            for (int num:list){
                list1.add(num);
            }
            if (set.add(list1)) {
                res.add(list1);
            }
            return;
        }
        for (int i=0;i<nums.length;i++){
            if(visited[i]!=1){
                list.add(nums[i]);
                visited[i] = 1;
                helper(nums,list,visited,i,length,time+1);
                visited[i] = 0;
                list.remove(list.size()-1);
            }

        }
    }
}
