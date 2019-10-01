import java.util.TreeSet;

public class containduplicates3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Integer> set = new TreeSet<>();

        for (int i=0;i<nums.length;i++){
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling!=null && Long.valueOf(ceiling)-Long.valueOf(nums[i])<=t){
                return true;
            }
            Integer floor = set.floor(nums[i]);
            if (floor!=null && Long.valueOf(nums[i])-Long.valueOf(floor)<=t){
                return true;
            }

            set.add(nums[i]);
            if (set.size()>k){
                set.remove(nums[i-k]);
            }

        }

        return false;
    }
}
