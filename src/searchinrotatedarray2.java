public class searchinrotatedarray2 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[left]) left++;   //重复了，跳过
            else if (nums[mid] > nums[left]) {
                //左边有序
                if (nums[mid] > target && nums[left] <= target) right = mid - 1;
                else left = mid + 1;
            } else {
                //右边有序
                if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}
