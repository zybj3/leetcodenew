public class Sortcolors {
    public void sortColors(int[] nums) {
        int current = 0;
        int left = 0, right = nums.length-1;
        while (left<right){
            if (nums[current]==0){
                swap(nums,current,left);
                left++;
                current++;
            }else if (nums[current]==2){
                swap(nums,current,right);
                right--;
            }else {
                current++;
            }
        }
    }

    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
