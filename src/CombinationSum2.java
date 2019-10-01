import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<Integer> curr = new ArrayList<>();
        helper(target,curr,candidates);
        for (List list1:res){
            Collections.sort(list1);
        }
        for (int i=0;i<res.size();i++){
            for (int j=0;j<res.size();j++){
                if (i==j){
                    continue;
                }

                if (res.get(i).equals(res.get(j))){
                        res.remove(res.get(j));
                }
            }

        }

        return res;
    }

    public void helper(int target, List<Integer> curr, int[] candidates){
        if (target==0){
            List<Integer> newlist = new ArrayList<>();
           for (int num:curr){
               newlist.add(num);
           }
            res.add(newlist);
            return;
        }
        if (target<0){
            // curr.remove(curr.size()-1);
            return;
        }
        for (int i=0;i<candidates.length;i++){
            if (candidates[i]<0){
                continue;
            }
            curr.add(candidates[i]);
            int oldnum = candidates[i];
            candidates[i] = -1;
            helper(target-oldnum,curr,candidates);
            curr.remove(curr.size()-1);
            candidates[i] = oldnum;
        }

    }

}
