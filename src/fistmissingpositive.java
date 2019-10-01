import java.util.Collections;

public class fistmissingpositive {

    public int firstMissingPositive(int[] nums) {
       int i = 0;
       while (i<nums.length-1){
           if (nums[i]>0 && nums[i]!=i+1 && nums[i]-1<nums.length && nums[nums[i]-1]!=nums[i]){
               int temp = nums[nums[i]-1];
               nums[nums[i]-1] = nums[i];
               nums[i] = temp;
           }else
               i++;
       }


       for (int j=0;j<nums.length;j++){
           if (nums[j]!=j+1){
               return j+1;
           }

           if (j==nums.length-1){
               return j+2;
           }
       }

       return 0;
    }

}
