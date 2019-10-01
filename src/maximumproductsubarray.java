import java.util.Arrays;

public class maximumproductsubarray {
    public int maxProduct(int[] nums) {
        int rowmin = nums[0];
        int rowmax = nums[0];
        int res = Math.max(rowmin,rowmax);
        for (int i=1;i<nums.length;i++){
            if (nums[i]<0){
                int temp = rowmax;
                rowmax = rowmin;
                rowmin = temp;
            }
            rowmin = Math.min(nums[i], rowmin*nums[i]);
            rowmax = Math.max(nums[i], rowmax*nums[i]);
            // System.out.println(rowmin + " " + rowmax);
            res = Math.max(res,rowmax);

        }

        return res;
    }


}
