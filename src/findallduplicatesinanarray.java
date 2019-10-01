import java.util.ArrayList;
import java.util.List;

public class findallduplicatesinanarray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            int index = nums[i];
            if (nums[Math.abs(index)-1]<0){
                res.add(Math.abs(Math.abs(index)));
            }
            else {
                nums[Math.abs(index)-1] *= -1;
            }
        }

        return res;
    }
}
