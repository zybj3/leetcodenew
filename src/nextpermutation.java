import java.util.Arrays;

public class nextpermutation {
    public void nextPermutation(int[] nums) {

        for (int i = nums.length-2; i>=0; i--){
            if (nums[i]<nums[i+1]){
                for (int j=nums.length-1; j>i; j--){
                    if (nums[j]>nums[i]){
                        break;
                    }

                    int temp = nums[j];
                    nums[i] = nums[j];
                    nums[j] = temp;

                    reverse(i+1, nums.length-1, nums);
                    return;
                }
            }
        }

        reverse(0, nums.length-1, nums);
    }


    public void reverse(int left, int end, int[] nums){
        while (left<=end){
            int temp = nums[left];
            nums[end] = temp;
            nums[left] = nums[end];

            left++;
            end--;
        }
    }

}
