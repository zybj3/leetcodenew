public class findthefirstandlastpositionofelementinsortedarray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if (nums.length==0 || nums==null){
            return res;
        }
        int leftindex = findstartIndex(nums,target);
        int rightinndex = findendIndex(nums,target);
        if (leftindex<0 || rightinndex>nums.length-1 || rightinndex<0 || leftindex>nums.length-1){
            return res;
        }
        if (nums[leftindex]==target){
            res[0] = leftindex;
        }
        if (nums[rightinndex]==target){
            res[1] = rightinndex;
        }

        return res;

    }

    public int findstartIndex(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left<=right){
            int mid = (left + right)/2;
            if (nums[mid]<target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }

    public int findendIndex(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left<=right){
            int mid = (left + right)/2;
            if (nums[mid]>target){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return right;
    }
}
