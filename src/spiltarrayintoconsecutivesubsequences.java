import java.util.HashMap;

public class spiltarrayintoconsecutivesubsequences {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> numscount = new HashMap<>(), sequencescount = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            numscount.put(nums[i],numscount.getOrDefault(nums[i],0)+1);
        }

        for (int i=0;i<nums.length;i++){
            if (numscount.getOrDefault(nums[i],0)<1){
                continue;
            }
            else if (sequencescount.getOrDefault(nums[i],0)>0){
                sequencescount.put(nums[i],sequencescount.get(nums[i])-1);
                sequencescount.put(nums[i]+1,sequencescount.getOrDefault(nums[i]+1,0)+1);
            }
            else if (numscount.getOrDefault(nums[i]+1,0) >0 &&
                    numscount.getOrDefault(nums[i]+2,0) >0){
                numscount.put(nums[i]+1,numscount.getOrDefault(nums[i]+1,0)-1);
                numscount.put(nums[i]+2,numscount.getOrDefault(nums[i]+2,0)-1);
                sequencescount.put(nums[i]+3,sequencescount.getOrDefault(nums[i]+3,0)+1);

            }
            else {
                return false;
            }
            numscount.put(nums[i],numscount.get(nums[i])-1);
        }

        return true;
    }
}
