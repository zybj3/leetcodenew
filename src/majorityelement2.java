import java.util.ArrayList;
import java.util.List;

public class majorityelement2 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums==null || nums.length==0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int count1 = 0, count2 = 0, a = 1, b = 2;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==a){
                count1++;
            }
            else if (nums[i]==b){
                count2++;
            }
            else if (count1==0){
                a = nums[i];
                count1 = 1;
            }
            else if (count2==0){
                b = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==a){
                count1++;
            }else if (nums[i]==b){
                count2++;
            }
        }

        if (count1>nums.length/3){
            res.add(a);
        }
        if (count2>nums.length/3){
            res.add(b);
        }

        return res;
    }
}
